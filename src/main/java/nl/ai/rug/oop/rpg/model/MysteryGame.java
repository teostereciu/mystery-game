package nl.ai.rug.oop.rpg.model;
import java.util.*;

public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 6;
    private int currentRoom;

    private Detective detective;
    private List<Room> rooms = new ArrayList<>();

    public MysteryGame() {
        this.init();
    }

    public void setDetective (Detective detective) {
        this.detective = detective;
    }

    public void init() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room(i);
            //rooms need connections to each other
            this.rooms.add(room);
        }

    }

    public void playGame(){}

    public static void main(String[] args) {
        MysteryGame mysteryGame = new MysteryGame();
        mysteryGame.playGame();
    }
}
