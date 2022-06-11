package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author Daniël
 */
public class NPC {
    private int NPCNumber;
    private String NPCname;
    private int roomNumber;
    private Image img;
    private final int dialogueType;
    private NPCDialogue dialogue;
    private int dialogueCounter;

    /**
     * Constructor for the object NPC
     * The object is given multiple functionalities when build
     * @param number of the npc being made
     * @param dialogueType which detective is chosen
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
        try {
            img = ImageIO.read(new File("src/main/resources/npcs/" + NPCname + ".png"));
            img = img.getScaledInstance((int) (img.getWidth(null) * 1.3), (int) (img.getHeight(null) * 1.3), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }

    /**
     * Builds the NPC "stacey"
     */
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "stacey";
        roomNumber = 0;
        coords.put("x", 450);
        coords.put("y", 100);
    }

    /**
     * Builds the NPC "samantha"
     */
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "sam";
        roomNumber = 2;
        coords.put("x", 240);
        coords.put("y", 100);
    }

    /**
     * Builds the NPC "davey"
     */
    private void Davey() {
        NPCNumber = 2;
        NPCname = "davey";
        roomNumber = 1;
        coords.put("x", 70);
        coords.put("y", 100);
    }

    /**
     * Builds the NPC "melvin"
     */
    private void Melvin() {
        NPCNumber = 3;
        NPCname = "melvin";
        roomNumber = 5;
    }

    /**
     * Builds the NPC "alex"
     */
    private void Alex() {
        this.NPCNumber = 4;
        this.NPCname = "alex";
        roomNumber = 4;
    }

    /**
     * Builds the NPC "kyle"
     */
    private void Kyle() {
        this.NPCNumber = 5;
        this.NPCname = "kyle";
        roomNumber = 3;
        coords.put("x", 500);
        coords.put("y", 100);
    }

    /**
     * @return the room number of the npc
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return the name of the npc
     */
    public String getName() {
        return NPCname;
    }

    /**
     * @return the image of the npc
     */
    public Image getImg() {
        return img;
    }

    /**
     * @return the number of the npc
     */
    public int getNPCNumber() {
        return NPCNumber;
    }

    /**
     * @return how far along the npc has progressed through its story
     */
    public int getDialogueCounter() {
        return dialogueCounter;
    }

    /**
     * increases the story progression of the npc
     */
    public void setDialogueCounter() {
        dialogueCounter++;
    }

    /**
     * @return the dialogue for this npc
     */
    public NPCDialogue getDialogue() {
        return dialogue;
    }

    /**
     * @Author Teo
     */
    private final HashMap<String, Integer> coords = new HashMap<>();
    public HashMap<String, Integer> getCoords() { // teo
        return coords;
    }
}
