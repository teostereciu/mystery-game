package nl.ai.rug.oop.rpg.model;
import java.io.*;
import java.util.*;

/**
 * @Author Daniël
 */
public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 7;
    public final int NUMBER_OF_ITEMS = 17;
    public final int NUMBER_OF_NPCS = 6;
    public final int TOTAL_INVENTORY_SLOTS = 4;
    private int currentRoom;

    private Detective detective;
    private final List<Room> rooms = new ArrayList<>();
    private Inventory inventory = new Inventory(TOTAL_INVENTORY_SLOTS);
    private int inventorySize;
    private int pickedUpItems = 0;

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
            NPC npc = new NPC(i, detective.getDetectiveKind());
            this.rooms.get(npc.getRoomNumber()).addNPC(npc);
        }
    }

    /* everything with regard to Detective */

    /**
     * sets the detective at the beginning of the game
     * @param detectiveName is which detective is chosen
     */
    public void setDetective(String detectiveName) {
        Detective detective = new Detective(detectiveName);
        this.detective = detective;
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
        //should notify the controller (or view?) that the room has changed
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

    // Make it an int function with return 0 if failed and 1 if picked up/interacted
    public void itemInteraction(int itemNumber) {
        if (itemNumber > pickedUpItems + TOTAL_INVENTORY_SLOTS) {
            //print statement that this object is not of interest to the detective as of yet
            return;
        }
        int slotnumber;
        Item item = rooms.get(currentRoom).getRoomItem(itemNumber);
        if (item == null) {
            //print an error statement
            return;
        } else if (item.getIsCarryAble() == 1) {
            slotnumber = inventory.addToInventory(item);
        } else {
            //print interaction statement
        }
        pickedUpItems++;
    }

    public void useItem (int itemNumber) {
        Item item = inventory.removeFromInventory(itemNumber);
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

    public static void main(String[] args) {
        MysteryGame mysteryGame = new MysteryGame();
        mysteryGame.playGame();
    }
}
