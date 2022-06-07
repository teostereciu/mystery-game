package nl.ai.rug.oop.rpg.model;
import java.io.*;
import java.util.*;

/**
 * @Author Daniël
 */
public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 7;
    public final int NUMBER_OF_ITEMS = 12;
    private int currentRoom; //cycles between 0 and (NUMBER_OF_ROOMS - 1)

    private Detective detective;
    private final List<Room> rooms = new ArrayList<>();
    private Inventory inventory = new Inventory();
    private int inventorySize;

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
     * @param number = 1 if going to right, = -1 if going to left
     */
    public void setCurrentRoom(int number) {
        if (number == 1) {
            currentRoom = (currentRoom+number)%NUMBER_OF_ROOMS;
        } else {
            if (currentRoom <= 1) {
                currentRoom = NUMBER_OF_ROOMS-1;
            } else {
                currentRoom = currentRoom+number;
            }
        }
        //should notify the controller (or view?) that the room has changed
    }

    /**
     * checks if room is open
     * @return 1 if open, 0 if closed
     */
    public int isRoomOpen(){
        return rooms.get(currentRoom).getIsOpen();
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
