package nl.rug.ai.rpg.model;
import java.util.*;

public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 5;

    private Detective detective;
    private ArrayList<Room> rooms = new ArrayList<>();

    public MysteryGame() {
    }

    public void setDetective (Detective detective) {
        this.detective = detective;
    }

    public void playGame() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            Room room = new Room(i);
            this.rooms.add(room);
        }
    }

    public static void main(String[] args) {
        MysteryGame mysteryGame = new MysteryGame();
        mysteryGame.playGame();
    }
}
