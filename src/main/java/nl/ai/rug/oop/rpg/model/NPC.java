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
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "stacey";
        roomNumber = 0;
        coords.put("x", 450);
        coords.put("y", 200);
    }
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "sam";
        roomNumber = 2;
        coords.put("x", 70);
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
    }
    private void Alex() {
        this.NPCNumber = 4;
        this.NPCname = "alex";
        roomNumber = 4;
    }
    private void Kyle() {
        this.NPCNumber = 5;
        this.NPCname = "kyle";
        roomNumber = 3;
        coords.put("x", 70);
        coords.put("y", 100);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return NPCname;
    }

    public Image getImg() {
        return img;
    }

    public int getNPCNumber() {
        return NPCNumber;
    }

    public int getDialogueCounter() {
        return dialogueCounter;
    }

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
