package nl.ai.rug.oop.rpg.model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;

/**
 * @Author Daniël
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

    private boolean isMessy = true;

    /* everything with regard to initializing game */

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

    private void setNPCs() {
        for (int i = 0; i < NUMBER_OF_NPCS; i++) {
            NPC npc = new NPC(i, detective.getDetectiveKind());
            this.rooms.get(npc.getRoomNumber()).setNPC(npc);
        }
    }

    /* everything with regard to Detective */

    /*/**
     * sets the detective at the beginning of the game
     * @param detectiveName is which detective is chosen
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

    /**
     * @return the name of the detective
     */
    public String getDetective() {
        return detective.getDetectiveName();
    }

    /* everything with regard to Rooms */

    /**
     * @return the total number of rooms
     */
    public int getNumberOfRooms(){
        return NUMBER_OF_ROOMS;
    }

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
                if (currentRoomNum == 4) {
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
                    System.out.println("I am inside the safe");
                    accessItems.get(15).setIsAvailable(1);
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
                increaseNPCProgressOutsideRoom(0);
                break;
        }
        return 1;
    }
    public int checkIfPlayable(Item item) {
        if (item.getIsPlayable() == 1) {
            return 1;
        }
        return 0;
    }

    /* Everything with regard to Inventory*/
    public int updateInventory(Item item, int removeSlashAddSlashUltimatelyRemove) {
        int result = 1;
        if (removeSlashAddSlashUltimatelyRemove == 1) {
            if(inventory.isFull()){
                return 0;
            }
            result = inventory.addToInventory(item);
            rooms.get(currentRoomNum).removeRoomItem(item);
        } else if (removeSlashAddSlashUltimatelyRemove == 0){
            rooms.get(currentRoomNum).addRoomItem(item);
            inventory.removeFromInventory(item);
        } else {
            usedItems.add(item);
            inventory.removeFromInventory(item);
        }
        notifyListeners();
        return result;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setFlashlightIsOn(boolean state) {
        flashlightIsOn = state;
        notifyListeners();
    }
    public boolean getFlashlightIsOn() { return flashlightIsOn; }

    public void setCodeHasBeenCracked(boolean state) {
        codeHasBeenCracked = state;
    }

    public boolean getIsMessy() { return isMessy; }
    public void notMessy() { isMessy = false; }

    /* everything with regard to NPCs */

    public void updateDialogue() {
        //lineCounter = (rooms.get(currentRoom).getNPC().getDialogueCounter()) * MAX_DIALOGUE_OPTIONS + 1; //TODO remove
        rooms.get(currentRoomNum).getNPC().getNPCDialogue().increaseLine();
        if (rooms.get(currentRoomNum).getNPC().getNPCDialogue().getDialogue(rooms.get(currentRoomNum).getNPC().getDialogueCounter() * MAX_DIALOGUE_OPTIONS + rooms.get(currentRoomNum).getNPC().getNPCDialogue().getCurrentKey()) == null) {
            rooms.get(currentRoomNum).getNPC().getNPCDialogue().setCurrentKey(0);
        }
        //if (rooms.get(currentRoomNum).getNPC().getNPCDialogue().getCurrentKey()) {
        //    notifyListeners();
        //    return 1;
        //}
        notifyListeners();
        //return 0;
    }

    private int increaseNPCProgress(int NPCnumber) {
        if (rooms.get(currentRoomNum).getNPC().getNPCNumber() == NPCnumber) {
            rooms.get(currentRoomNum).getNPC().updateDialogueCounter();
            rooms.get(currentRoomNum).getNPC().getNPCDialogue().setCurrentKey(0);
            return 1;
        }
        return 0;
    }

    private void increaseNPCProgressOutsideRoom(int roomNumber) {
        rooms.get(roomNumber).getNPC().updateDialogueCounter();
        rooms.get(roomNumber).getNPC().getNPCDialogue().setCurrentKey(0);
    }

    public void increaseItemProgress(Item item) {

    }

    /* everything with regard to gameState */

    /**
     * Function that loads in a game state
     */
    /*public void loadGame() {
        try (Scanner loadState = new Scanner(new FileInputStream("saveState.txt"))) {
            currentRoomNum = loadState.nextInt();
            inventorySize = loadState.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Function that saves the game state
     */
    /*public void saveGame() {
        if (!new File("saveState.txt").exists()) {
            new File("saveState").mkdir();
        }
        try (PrintWriter saveState = new PrintWriter(new FileOutputStream("saveState.txt"))){
            saveState.println(currentRoomNum);
            saveState.println(inventorySize);
            //first needs to be # items in inventory followed by the items
            //also need to save developments from NPCs
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to add listeners.
     * @param listener
     * @author Csanád Végh
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


    public void addListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifies listeners.
     * @author Csanád Végh
     */
    private void notifyListeners() {
        PropertyChangeEvent payload = new PropertyChangeEvent(this, "game", null, null);
        for (PropertyChangeListener listener : listeners) {
            listener.propertyChange(payload);
        }
    }



}

