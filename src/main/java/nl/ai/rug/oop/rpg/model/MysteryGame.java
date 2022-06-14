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
    private boolean flashlightIsOn = false;

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
            this.rooms.get(item.getRoomNumber()).addRoomItem(item);
        }
    }

    private void setNPCs() {
        for (int i = 0; i < NUMBER_OF_NPCS; i++) {
            NPC npc = new NPC(i, detective.getDetectiveKind());
            //TODO  NPC npc = new NPC(i, detective.getDetectiveKind());
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
            detectiveName = "SarahSalwitt";
        } else {
            detectiveName = "DoctorDormitory";
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

    /**
     * Picks up or interacts with an item if the player has progressed enough through the story
     * @param itemNumber is the number of the item that is picked up/interacted with
     */

    //TODO  Make it an int function with return 0 if failed and 1 if picked up/interacted
    public void itemInteraction(int itemNumber) {
        if (itemNumber > pickedUpItems + TOTAL_INVENTORY_SLOTS) {
            //TODO print statement that this object is not of interest to the detective as of yet
            return;
        }
        int slotnumber;
        Item item = rooms.get(currentRoomNum).getRoomItem(itemNumber);
        if (item == null) {
            //TODO print an error statement
            return;
        } else if (item.getIsCarryAble() == 1) {
            //slotnumber = inventory.addToInventory(item);
            //TODO give the slotnumber to view so it knows where to put item
        } else {
            //TODO print interaction statement
        }
        pickedUpItems++;
    }

    public void updateProgress(Item item) {
        switch(item.getItemName()){
            case "hat":
                increaseNPCProgress(1);
                increaseNPCProgress(0);
                getRoom(3).setIsOpen(true);
                updateInventory(item, 2);
                break;
            case "euro":
                increaseNPCProgress(0);
                increaseNPCProgress(1);
                getRoom(5).setIsOpen(true);
                updateInventory(item, 2);
                break;
            case "phone":
                increaseNPCProgress(0);
                increaseNPCProgress(1);
                updateInventory(item, 2);
                break;
            case "coffee":
                getRoom(4).setIsOpen(true);
                updateInventory(item, 2);
                break;
            case "cleaning-supplies":
                //get access to safe
                updateInventory(item, 2);
                break;
            case "flashlight":
                increaseNPCProgress(1);
                increaseNPCProgress(5);
                //light up melvin's room
                setFlashlightIsOn(!getFlashlightIsOn());
                break;
            case "Video Tape":
                //new dialogue
                updateInventory(item, 2);
                break;
            case "hammer":
                if (checkIfPlayable(item) == 0){
                    //todo print "this item cannot be played yet" or something
                    break;
                }
                //break desk lock
                updateInventory(item, 2);
                break;
        }
    }

    /* Everything with regard to Inventory*/
    public int updateInventory(Item item, int removeSlashAddSlashUltimatelyRemove) {
        int result = 1;
        if (removeSlashAddSlashUltimatelyRemove == 1) {
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

    public int getInventorySize() {
        return inventorySize;
    }
    public void setFlashlightIsOn(boolean n) {
        flashlightIsOn = n;
        notifyListeners();
    }
    public boolean getFlashlightIsOn() { return flashlightIsOn; }

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

    public void checkForProgress(int NPCnumber) {
        if (getInventory().checkProgress(NPCnumber) == 1 /*TODO add check that sees if items can be played already*/ ) {
            increaseNPCProgress(NPCnumber);
        }
    }

    public void increaseNPCProgress(int roomNumber) {
        rooms.get(roomNumber).getNPC().updateDialogueCounter();
    }

    public void increaseItemProgress(Item item) {

    }

    public int checkIfPlayable(Item item) {
        if (item.getItemNumber() <= usedItems.size()) {
            return 1;
        }
        return 0;
    }

    /* everything with regard to gameState */

    /**
     * Function that loads in a game state
     */
    public void loadGame() {
        try (Scanner loadState = new Scanner(new FileInputStream("saveState.txt"))) {
            currentRoomNum = loadState.nextInt();
            inventorySize = loadState.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function that saves the game state
     */
    public void saveGame() {
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

