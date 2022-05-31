package nl.rug.ai.rpg.model;
import java.util.*;

public class MysteryGame {
    public final int NUMBER_OF_ROOMS = 5;

    private Detective detective;
    private ArrayList<Room> rooms;

    public MysteryGame(Detective detective) {
        this.detective = detective;
    }

    public void playGame() {
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {

        }
    }

    public static void main(String[] args) {
        Detective detective = new detective();
        MysteryGame mysteryGame = new MysteryGame(detective);
        mysteryGame.playGame();
    }
}
