package nl.ai.rug.oop.rpg.model;

import java.awt.*;
import java.util.HashMap;

/**
 * @Author Daniël
 */
public class NPC {
    private int NPCNumber;
    private String NPCname;
    private int roomNumber;
    private final int dialogueType;
    private NPCDialogue dialogue;
    private int dialogueCounter;

    //TODO make failsafe to ensure player cannot skip steps
    public NPC(int number, int dialogueType){
        this.dialogueType = dialogueType;
        this.dialogue = new NPCDialogue(number, dialogueType);
        NPCNumber = number;
        dialogueCounter = 0;
        switch (number) {
            case (0) -> this.Stacey();
            case (1) -> this.Samantha();
            case (2) -> this.Davey();
            case (3) -> this.Melvin();
            case (4) -> this.Alex();
            case (5) -> this.Kyle();
            default -> {
            }
        }
    }
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "stacey";
        roomNumber = 0;
        coords.put("x", 450);
        coords.put("y", 100);
    }
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "sam";
        roomNumber = 2;
        coords.put("x", 240);
        coords.put("y", 100);
    }
    private void Davey() {
        NPCNumber = 2;
        NPCname = "davey";
        roomNumber = 1;
        coords.put("x", 70);
        coords.put("y", 100);
    }
    private void Melvin() {
        NPCNumber = 3;
        NPCname = "melvin";
        roomNumber = 5;
        coords.put("x", 100);
        coords.put("y", 100);
    }
    private void Alex() {
        this.NPCNumber = 4;
        this.NPCname = "alex";
        roomNumber = 4;
        coords.put("x", 100);
        coords.put("y", 100);
    }
    private void Kyle() {
        this.NPCNumber = 5;
        this.NPCname = "kyle";
        roomNumber = 3;
        coords.put("x", 500);
        coords.put("y", 100);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return NPCname;
    }

    public int getNPCNumber() {
        return NPCNumber;
    }

    public int getDialogueCounter() {
        return dialogueCounter;
    }

    public NPCDialogue getNPCDialogue() {
        return dialogue;
    }

    public void updateDialogueCounter() {
        dialogueCounter ++;
    }


    /**
     * @Author Teo
     */
    private final HashMap<String, Integer> coords = new HashMap<>();

    public HashMap<String, Integer> getCoords() { // teo
        return coords;
    }
}