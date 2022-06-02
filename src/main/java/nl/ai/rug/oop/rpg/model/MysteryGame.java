package nl.ai.rug.oop.rpg.model;
import java.io.*;
import java.util.*;

/**
 * @Author Daniël
 */
public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 6;
    private int currentRoom;

    private Detective detective;
    private List<Room> rooms = new ArrayList<>();
    private Inventory inventory = new Inventory();
    private int inventorySize;

    /* everything with regard to initializing game */

    public MysteryGame() {
        this.init();
    }

    public void init() {
        currentRoom = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room(i);
            this.rooms.add(room);
        }

    }

    /* everything with regard to Detective */

    public void setDetective(String detectiveName) {
        Detective detective = new Detective(detectiveName);
        this.detective = detective;
    }

    public String getDetective() {
        return detective.getDetectiveName();
    }

    /* everything with regard to Rooms */
    public int getNumberOfRooms(){
        return NUMBER_OF_ROOMS;
    }

    public void setCurrentRoom(int number) {
        currentRoom = number;
        //should notify the controller (or view?) that the room has changed
    }

    /* everything with regard to gameState */

    public void playGame(){}
    public void loadGame() {
        try (Scanner loadState = new Scanner(new FileInputStream("saveState.txt"))) {
            currentRoom = loadState.nextInt();
            inventorySize = loadState.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
