package nl.ai.rug.oop.rpg.model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;

/**
 * The MysteryGame Object is the instance of the game being played.
 * All other objects are stored inside this object.
 * @Author Dancoko
 */
public class MysteryGame {
    Collection<PropertyChangeListener> listeners = new ArrayList<>();
    public final int NUMBER_OF_ROOMS = 7;
    public final int NUMBER_OF_ITEMS = 17;
    public final int NUMBER_OF_NPCS = 6;
    public final int TOTAL_INVENTORY_SLOTS = 5;
    public final int MAX_DIALOGUE_OPTIONS = 100; /* There are max 100 dialogue sentences per set of dialogue/progress */
    private int currentRoomNum;

    private Detective detective;
    private final List<Room> rooms = new ArrayList<>();
    private Inventory inventory = new Inventory(TOTAL_INVENTORY_SLOTS);
    private int inventorySize;
    private int pickedUpItems = 0;
    private ArrayList<Item> usedItems = new ArrayList<>();
    public ArrayList<Item> accessItems = new ArrayList<>();
    private boolean flashlightIsOn = false;
    private boolean flashlightHasBeenUsed = false;
    private boolean computerHasBeenUsed = false;
    private boolean electricalPanelHasBeenUsed = false;
    private boolean safeHasBeenAccessed = false;
    private boolean codeHasBeenCracked = false;
    private boolean beerCrateHasBeenFound = false;

    private boolean isMessy = true;

    /* everything with regard to initializing game */

    /**
     * The constructor for the MysteryGame
     */
    public MysteryGame() {
        this.init();
    }

    /**
     * Initiates a game
     */
    public void init() {
        currentRoomNum = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room(i);
            this.rooms.add(room);
        }

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            Item item = new Item(i);
            accessItems.add(item);
            this.rooms.get(item.getRoomNumber()).addRoomItem(item);
        }
    }

    /**
     * Initialises the NPCs
     */
    private void setNPCs() {
        for (int i = 0; i < NUMBER_OF_NPCS; i++) {
            NPC npc = new NPC(i, detective.getDetectiveKind());
            this.rooms.get(npc.getRoomNumber()).setNPC(npc);
        }
    }

    /* everything with regard to Detective */

    /**
     * sets the detective at the beginning of the game
     * @param isGood is which detective is chosen
     */

    public void setDetective(int isGood) {
        String detectiveName;
        if (isGood == 0) {
            detectiveName = "DoctorDormitory";
        } else {
            detectiveName = "SarahSalwitt";
        }
        detective = new Detective(detectiveName);
        setNPCs();
    }

    /* everything with regard to Rooms */

    /**
     * Gives the object Room coupled to a certain roomNumber
     * @param roomNumber the number of the room
     * @return the Room coupled to that roomNumber
     */
    public Room getRoom(int roomNumber) { // note from teo: needed this
        return rooms.get(roomNumber);
    }

    /**
     * Changes the current room
     * @param number the number of the new room
     */
    public void setCurrentRoomNum(int number) {
        currentRoomNum = number;
        notifyListeners();
    }

    /**
     * @return the number of the current room
     */
    public int getCurrentRoomNum() {
        return currentRoomNum;
    }

    /**
     * checks if room is open
     * @return 1 if open, 0 if closed
     */
    public boolean isRoomOpen(){
        return rooms.get(currentRoomNum).getIsOpen();
    }

    /* everything with regard to items */

    /**
     * Whenever an Item is used, this function checks whether it can be played
     * in the current state and if yes, update the progress of the game
     * @param item the item played
     * @return a value to the view: 1 = succes,
     *                  2 = item != playable;
     *                  3 = item is used in the wrong room
     */
    public int updateProgress(Item item) {
        switch(item.getItemName()){
            case "hat":
                if (increaseNPCProgress(2) == 1) {
                    increaseNPCProgressOutsideRoom(0);
                    accessItems.get(1).setIsPlayable(1);
                    accessItems.get(4).setIsPlayable(1);
                    getRoom(3).setIsOpen(true);
                    updateInventory(item, 2);
                } else {
                    return 3; //"this is wrong room"
                }
                break;
            case "phone":
                if (checkIfPlayable(item) == 0){
                    return 2; //"this item cannot be played yet" or something
                }
                if (increaseNPCProgress(2) == 1) {
                    increaseNPCProgressOutsideRoom(0);
                    accessItems.get(2).setIsPlayable(1);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "euro":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (increaseNPCProgress(2) == 1) {
                    getRoom(5).setIsOpen(true);
                    updateInventory(item, 2);
                    accessItems.get(3).setIsPlayable(1);
                    accessItems.get(5).setIsPlayable(1);
                } else {
                    return 3;
                }
                break;
            case "coffee":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (currentRoomNum == 0) {
                    //accessItems.get(4).setIsPlayable(1);
                    getRoom(4).setIsOpen(true);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "cleaning-supplies":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (increaseNPCProgress(5) == 1) {
                    notMessy();
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "flashlight":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (!flashlightHasBeenUsed) {
                    if (increaseNPCProgress(3) == 1) {
                        increaseNPCProgressOutsideRoom(3);
                        setFlashlightIsOn(!getFlashlightIsOn());
                        accessItems.get(6).setIsPlayable(1);
                        flashlightHasBeenUsed = true;
                    } else {
                        return 3;
                    }
                } else {
                    if (currentRoomNum == 5) {
                        setFlashlightIsOn(!getFlashlightIsOn());
                    } else {
                        return 3;
                    }
                }
                break;
            case "camera":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                accessItems.get(7).setIsPlayable(1);
                accessItems.get(8).setIsPlayable(1);
                updateInventory(item, 2);
                break;
            case "computer":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (!computerHasBeenUsed) {
                    increaseNPCProgressOutsideRoom(0);
                    increaseNPCProgressOutsideRoom(5);
                    increaseNPCProgressOutsideRoom(4);
                    computerHasBeenUsed = true;
                }
                break;
            case "hammer":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (increaseNPCProgress(4) == 1) {
                    accessItems.get(9).setIsPlayable(1);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "locked-drawer":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (detective.getDetectiveKind() == 0) {
                    accessItems.get(12).setIsAvailable(1);
                    accessItems.get(12).setIsPlayable(1);
                } else {
                    accessItems.get(10).setIsPlayable(1);
                    accessItems.get(11).setIsAvailable(1);
                    accessItems.get(11).setIsPlayable(1);
                }
                break;
            case "screwdriver":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (currentRoomNum == 1) {
                    accessItems.get(13).setIsPlayable(1);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "scissors":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (currentRoomNum == 1) {
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "mouse":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (increaseNPCProgress(3) == 1) {
                    accessItems.get(14).setIsPlayable(1);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "electrical-panel":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (!electricalPanelHasBeenUsed) {
                    increaseNPCProgressOutsideRoom(5);
                    accessItems.get(14).setIsPlayable(1);
                    electricalPanelHasBeenUsed = true;
                }
                break;
            case "safe":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (codeHasBeenCracked && !safeHasBeenAccessed) {
                    accessItems.get(15).setIsPlayable(1);
                    increaseNPCProgressOutsideRoom(5);
                    increaseNPCProgressOutsideRoom(4);
                    safeHasBeenAccessed = true;
                }
                break;
            case "key":
                if (checkIfPlayable(item) == 0){
                    return 2;
                }
                if (currentRoomNum == 0) {
                    rooms.get(6).setIsOpen(true);
                    accessItems.get(16).setIsPlayable(1);
                    updateInventory(item, 2);
                } else {
                    return 3;
                }
                break;
            case "crate":
                if(!beerCrateHasBeenFound) {
                    increaseNPCProgressOutsideRoom(0);
                    beerCrateHasBeenFound = true;
                }
                break;
        }
        notifyListeners();
        return 1;
    }

    /**
     * Checks whether a given item is playable
     * @param item is the given item
     * @return whether item is playable (1) or not (0)
     */
    public int checkIfPlayable(Item item) {
        if (item.getIsPlayable() == 1) {
            return 1;
        }
        return 0;
    }

    /* Everything with regard to Inventory*/

    /**
     * This function either removes an item from the inventory back to the room,
     * adds an item from the room to the inventory or
     * completely removes the item when it is successfully played
     * @param item is the Item to be removed, added or completely removed
     * @param state tells what is going to happen with the item
     *              0 = remove / return to room
     *              1 = add to inventory
     *              else = remove from game
     * @return whether succesful in action (1) or not (0)
     */
    public int updateInventory(Item item, int state) {
        int result = 1;
        if (state == 1) {
            if(inventory.isFull()){
                return 0;
            }
            result = inventory.addToInventory(item);
            rooms.get(currentRoomNum).removeRoomItem(item);
        } else if (state == 0){
            rooms.get(currentRoomNum).addRoomItem(item);
            inventory.removeFromInventory(item);
        } else {
            usedItems.add(item);
            inventory.removeFromInventory(item);
        }
        notifyListeners();
        return result;
    }

    /**
     * @return the inventory of the player
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Changes Melvins room (room 5) from dark to light and vice versa
     * @param state is the state the flashlight/Melvins room should be in
     *              0 = dark
     *              1 = lit up
     */
    public void setFlashlightIsOn(boolean state) {
        flashlightIsOn = state;
        notifyListeners();
    }

    /**
     * @return whether the flashlight is on (true) or off (false)
     */
    public boolean getFlashlightIsOn() { return flashlightIsOn; }

    /**
     * When the safe is cracked, this function will set setCodeHasBeenCracked to true
     * @param state is the state the variable will be put in.
     *              (will only be true when the safe is cracked)
     */
    public void setCodeHasBeenCracked(boolean state) {
        codeHasBeenCracked = state;
    }

    /**
     * @return true if cleaning-supplies has not been used and false if has been used
     */
    public boolean getIsMessy() { return isMessy; }

    /**
     * Function called when cleaning supplies are used.
     * Removes the mess from Davey/Kyles room
     */
    public void notMessy() { isMessy = false; }

    /* everything with regard to NPCs */

    /**
     * Updates the dialogue of the NPC in the given room
     */
    public void updateDialogue() {
        rooms.get(currentRoomNum).getNPC().getNPCDialogue().increaseLine();
        if (rooms.get(currentRoomNum).getNPC().getNPCDialogue().getDialogue(rooms.get(currentRoomNum).getNPC().getDialogueCounter() * MAX_DIALOGUE_OPTIONS + rooms.get(currentRoomNum).getNPC().getNPCDialogue().getCurrentKey()) == null) {
            rooms.get(currentRoomNum).getNPC().getNPCDialogue().setCurrentKey(0);
        }
        notifyListeners();
    }

    /**
     * Increases the dialogue counter of a given NPC
     * Player has to be in the same room as the NPC
     * @param NPCnumber is the number of the NPC
     * @return 1 if successfully increased or 0 if unsuccessful
     */
    private int increaseNPCProgress(int NPCnumber) {
        if (rooms.get(currentRoomNum).getNPC().getNPCNumber() == NPCnumber) {
            rooms.get(currentRoomNum).getNPC().updateDialogueCounter();
            rooms.get(currentRoomNum).getNPC().getNPCDialogue().setCurrentKey(0);
            return 1;
        }
        return 0;
    }

    /**
     * Increases the dialogue counter of a given NPC
     * Player does not have to be in the same room as the NPC
     * @param roomNumber is the roomNumber of the NPC
     */
    private void increaseNPCProgressOutsideRoom(int roomNumber) {
        rooms.get(roomNumber).getNPC().updateDialogueCounter();
        rooms.get(roomNumber).getNPC().getNPCDialogue().setCurrentKey(0);
    }

    /**
     * Method for saving the current state of the game.
     * @author veghcsanad
     */
    public void saveGame(){
        Properties properties = new Properties();
        properties.setProperty("detectiveKind", String.valueOf(detective.getDetectiveKind()));
        properties.setProperty("inventorySize", String.valueOf(inventory.getItemsArray().size()));
        for(int i = 0; i<inventory.getItemsArray().size(); i++){
            properties.setProperty("inventoryItems" + i, String.valueOf(inventory.getItemsArray().get(i).getItemNumber()));
        }
        for(int i = 0; i<NUMBER_OF_ITEMS; i++){
            properties.setProperty("isPlayable" + i, String.valueOf(accessItems.get(i).getIsPlayable()));
            properties.setProperty("isAvailable" + i, String.valueOf(accessItems.get(i).getIsAvailable()));
        }
        properties.setProperty("currentRoomNum", String.valueOf(currentRoomNum));
        properties.setProperty("flashlightIsOn", String.valueOf(flashlightIsOn));
        properties.setProperty("isMessy", String.valueOf(isMessy));
        properties.setProperty("flashlightHasBeenUsed", String.valueOf(flashlightHasBeenUsed));
        properties.setProperty("computerHasBeenUsed", String.valueOf(computerHasBeenUsed));
        properties.setProperty("electricalPanelHasBeenUsed", String.valueOf(electricalPanelHasBeenUsed));
        properties.setProperty("safeHasBeenAccessed", String.valueOf(safeHasBeenAccessed));
        properties.setProperty("codeHasBeenCracked", String.valueOf(codeHasBeenCracked));
        properties.setProperty("beerCrateHasBeenFound", String.valueOf(beerCrateHasBeenFound));
        for(int i=0; i<NUMBER_OF_ROOMS; i++){
            if(i != NUMBER_OF_ROOMS-1) {
                properties.setProperty("dialogueCounter" + i, String.valueOf(rooms.get(i).getNPC().getDialogueCounter()));
            }
            properties.setProperty("isOpen" + i, String.valueOf(rooms.get(i).getIsOpen()));
            properties.setProperty("numberOfItemsInRoom"+i, String.valueOf(rooms.get(i).getRoomItems().size()));
            for(int j=0; j<rooms.get(i).getRoomItems().size(); j++){
                properties.setProperty("roomItems" + i + "," + j, String.valueOf(rooms.get(i).getRoomItems().get(j).getItemNumber()));
            }
        }
        try(FileOutputStream output = new FileOutputStream("saved_properties.txt")){
            properties.store(output, "The state of the game:");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for loading a saved game.
     * @author veghcsanad
     */
    public void loadGame(){
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("saved_properties.txt")){
            properties.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }
        setDetective(Integer.parseInt(properties.getProperty("detectiveKind")));
        inventory.getItemsArray().clear();
        for(int i = 0; i < Integer.parseInt(properties.getProperty("inventorySize"));i++){
            inventory.getItemsArray().add(accessItems.get(Integer.parseInt(properties.getProperty("inventoryItems"+i))));
        }
        for(int i = 0; i<NUMBER_OF_ITEMS; i++){
            accessItems.get(i).setIsPlayable(Integer.parseInt(properties.getProperty("isPlayable"+i)));
            accessItems.get(i).setIsPlayable(Integer.parseInt(properties.getProperty("isAvailable"+i)));
        }
        setCurrentRoomNum(Integer.parseInt(properties.getProperty("currentRoomNum")));
        setFlashlightIsOn(Boolean.parseBoolean(properties.getProperty("flashlightIsOn")));
        isMessy = Boolean.parseBoolean(properties.getProperty("isMessy"));
        flashlightHasBeenUsed = Boolean.parseBoolean(properties.getProperty("flashlightHasBeenUsed"));
        computerHasBeenUsed = Boolean.parseBoolean(properties.getProperty("computerHasBeenUsed"));
        electricalPanelHasBeenUsed = Boolean.parseBoolean(properties.getProperty("electricalPanelHasBeenUsed"));
        safeHasBeenAccessed = Boolean.parseBoolean(properties.getProperty("safeHasBeenAccessed"));
        codeHasBeenCracked = Boolean.parseBoolean(properties.getProperty("codeHasBeenCracked"));
        beerCrateHasBeenFound = Boolean.parseBoolean(properties.getProperty("beerCrateHasBeenFound"));
        for(int i=0; i<NUMBER_OF_ROOMS; i++){
            if(i != NUMBER_OF_ROOMS-1){
                rooms.get(i).getNPC().setDialogueCounter(Integer.parseInt(properties.getProperty("dialogueCounter"+i)));
            }
            rooms.get(i).setIsOpen(Boolean.parseBoolean(properties.getProperty("isOpen"+i)));
            rooms.get(i).getRoomItems().clear();
            for(int j = 0; j<Integer.parseInt(properties.getProperty("numberOfItemsInRoom"+i));j++){
                rooms.get(i).getRoomItems().add(accessItems.get(Integer.parseInt(properties.getProperty("roomItems"+ i + "," + j))));
            }
        }
        notifyListeners();
    }

    /**
     * Method for adding listeners. Implemented from lecture code.
     * @param listener
     * @author veghcsanad
     */
    public void addListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifies listeners. Implemented from lecture code.
     * @author veghcsanad
     */
    private void notifyListeners() {
        PropertyChangeEvent payload = new PropertyChangeEvent(this, "game", null, null);
        for (PropertyChangeListener listener : listeners) {
            listener.propertyChange(payload);
        }
    }
}