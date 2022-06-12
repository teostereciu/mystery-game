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
    public final int MAX_DIALOGUE_OPTIONS = 10; /* There are max 10 dialogue sentences per set of dialogue/progress */
    private int currentRoom;

    private Detective detective;
    private final List<Room> rooms = new ArrayList<>();
    private Inventory inventory = new Inventory(TOTAL_INVENTORY_SLOTS);
    private int inventorySize;
    private int pickedUpItems = 0;


    //TODO Rewrite the catch parts in NPC, ROOM and Item


    /* everything with regard to initializing game */

    public MysteryGame() {
        this.init();
    }

    /**
     * Initiates a game
     */
    public void init() {
        currentRoom = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room(i);
            this.rooms.add(room);
        }

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            Item item = new Item(i);
            this.rooms.get(item.getRoomNumber()).addRoomItem(item);
        }

        for (int i = 0; i < NUMBER_OF_NPCS; i++) {
            NPC npc = new NPC(i, 0);
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
        System.out.println("You chose detective" + detectiveName); //todo remove
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

    /**
     * Changes the current room
     * @param number the number of the new room
     */
    public void setCurrentRoom(int number) {
        currentRoom = number;
        notifyListeners();
    }
    public int getCurrentRoom() {
        return currentRoom;
    }

    /**
     * checks if room is open
     * @return 1 if open, 0 if closed
     */
    public int isRoomOpen(){
        return rooms.get(currentRoom).getIsOpen();
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
        Item item = rooms.get(currentRoom).getRoomItem(itemNumber);
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

    /*public void useItem (int itemNumber) {
        Item item = inventory.removeFromInventory(itemNumber);
    }*/

    /* everything with regard to NPCs */

    private int lineCounter;
    public int getLineCounter() {
        return lineCounter;
    }
    public void updateDialogue() {
        //lineCounter = (rooms.get(currentRoom).getNPC().getDialogueCounter()) * MAX_DIALOGUE_OPTIONS + 1;
        rooms.get(currentRoom).getNPC().getNPCDialogue().increaseLine();
        if (rooms.get(currentRoom).getNPC().getNPCDialogue().getDialogue(rooms.get(currentRoom).getNPC().getDialogueCounter() * MAX_DIALOGUE_OPTIONS + rooms.get(currentRoom).getNPC().getNPCDialogue().getCurrentKey()) == null) {
            rooms.get(currentRoom).getNPC().getNPCDialogue().setCurrentKey(0);
        }
        notifyListeners();
    }

    public int getMAX_DIALOGUE_OPTIONS() {
        return MAX_DIALOGUE_OPTIONS;
    }

    /* everything with regard to gameState */

    /**
     * Function that starts the game
     */
    public void playGame(){}

    /**
     * Function that loads in a game state
     */
    public void loadGame() {
        try (Scanner loadState = new Scanner(new FileInputStream("saveState.txt"))) {
            currentRoom = loadState.nextInt();
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
            saveState.println(currentRoom);
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


    /**
     * @Author Teo
     * @param roomIdx
     * @return
     */
    public Room getRoom(int roomIdx) { // note from teo: needed this
        return rooms.get(roomIdx);
    }
    public int updateInventory(Item item, int removeSlashAdd) {
        int result = 1;
        if (removeSlashAdd == 1) {
            result = inventory.addToInventory(item);
            if (result == 1) {
                rooms.get(currentRoom).removeRoomItem(item);
            }
        } else {
            rooms.get(currentRoom).addRoomItem(item);
            inventory.removeFromInventory(item);
        }
        notifyListeners();
        return result;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public int getInvetorySize() {
        return inventorySize;
    }
}

