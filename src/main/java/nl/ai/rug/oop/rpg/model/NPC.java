package nl.ai.rug.oop.rpg.model;

import java.awt.*;
import java.util.HashMap;

/**
 * Class for the NPC object.
 * NPCs interact with the player through dialogue and
 * give hints/missions about what the player should be doing.
 * @Author Dancoko
 */
public class NPC {
    private int NPCNumber;
    private String NPCname;
    private int roomNumber;
    private final int dialogueType;
    private NPCDialogue dialogue;
    private int dialogueCounter;
    private final HashMap<String, Integer> coords = new HashMap<>();

    /**
     * A constructor for the NPC object.
     * Each NPC has pre-programmed values and functions
     * @param number is the number of the NPC
     * @param dialogueType is the version of detective which influences dialogue:
     *                     good cop (0) or bad cop (1)
     */
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

    /**
     * Initialises the Stacey NPC
     */
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "stacey";
        roomNumber = 0;
        coords.put("x", 450);
        coords.put("y", 100);
    }

    /**
     * Initialises the Samantha NPC
     */
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "sam";
        roomNumber = 2;
        coords.put("x", 240);
        coords.put("y", 100);
    }

    /**
     * Initialises the Davey NPC
     */
    private void Davey() {
        NPCNumber = 2;
        NPCname = "davey";
        roomNumber = 1;
        coords.put("x", 70);
        coords.put("y", 100);
    }

    /**
     * Initialises the Melvin NPC
     */
    private void Melvin() {
        NPCNumber = 3;
        NPCname = "melvin";
        roomNumber = 5;
        coords.put("x", 300);
        coords.put("y", 100);
    }

    /**
     * Initialises the Alex NPC
     */
    private void Alex() {
        this.NPCNumber = 4;
        this.NPCname = "alex";
        roomNumber = 4;
        coords.put("x", 100);
        coords.put("y", 100);
    }

    /**
     * Initialises the Kyle NPC
     */
    private void Kyle() {
        this.NPCNumber = 5;
        this.NPCname = "kyle";
        roomNumber = 3;
        coords.put("x", 500);
        coords.put("y", 100);
    }

    /**
     * @return the roomNumber coupled to the NPC
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return the name of the NPC
     */
    public String getName() {
        return NPCname;
    }

    /**
     * @return the number of the NPC
     */
    public int getNPCNumber() {
        return NPCNumber;
    }

    /**
     * @return how far in dialogue the NPC has progressed
     */
    public int getDialogueCounter() {
        return dialogueCounter;
    }

    /**
     * @return the NPCDialogue object coupled to the NPC
     */
    public NPCDialogue getNPCDialogue() {
        return dialogue;
    }

    /**
     * Increases the progression of dialogue for the NPC
     */
    public void updateDialogueCounter() {
        dialogueCounter++;
    }


    /**
     * @return the coords of the NPC
     */
    public HashMap<String, Integer> getCoords() { // teo
        return coords;
    }

    /**
     * Updates the dialogueCounter of the NPC
     * @param counter is the new value to set the counter to
     */
    public void setDialogueCounter(int counter) {
        dialogueCounter = counter;
    }
}