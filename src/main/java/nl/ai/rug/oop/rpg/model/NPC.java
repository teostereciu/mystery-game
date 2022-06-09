package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author Daniël
 */
public class NPC {
    private int NPCNumber;
    private String NPCname;
    private int roomNumber;
    private Image img;
    private final double scale = 1.3;
    private final int dialogueType;

    public NPC(int number, int dialogueType){
        this.dialogueType = dialogueType;
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
            img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }

    }
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "stacey";
        roomNumber = 0;
    }
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "sam";
        roomNumber = 2;
    }
    private void Davey() {
        NPCNumber = 2;
        NPCname = "davey";
        roomNumber = 1;
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
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Image getImg() {
        return img;
    }
}
