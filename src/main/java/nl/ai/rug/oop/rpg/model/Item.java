package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author Daniël
 */
public class Item {
    private String itemName;
    private final int itemNumber;
    private int isCarryAble;
    private int roomNumber;
    private double scale;
    private Image img;


    //change names of items to the file names
    public Item(int itemNumber){
        this.itemNumber = itemNumber;
        isCarryAble = 1;
        switch (itemNumber) {
            case(0):
                itemName = "Hat";
                roomNumber = 2;
            case(1):
                itemName = "Money";
                break;
            case(2):
                itemName = "Phone";
                roomNumber = 3;
                isCarryAble = 0;
                break;
            case(3):
                itemName = "Coffee";
                roomNumber = 1;
                break;
            case(4):
                itemName = "Cleaning Supplies";
                roomNumber = 0;
                break;
            case(5):
                itemName = "Flashlight";
                roomNumber = 3;
                break;
            case(6):
                itemName = "Video Tape";
                roomNumber = 5;
                break;
            case(7):
                itemName = "Computer";
                roomNumber = 4;
                isCarryAble = 0;
                break;
            case(8):
                itemName = "Hammer";
                roomNumber = 1;
                break;
            case(9):
                itemName = "Locked desk";
                roomNumber = 4;
                isCarryAble = 0;
                break;
            case(10):
                itemName = "Screwdriver";
                roomNumber = 2;
                break;
            case(11):
                itemName = "Scissors";
                roomNumber = 4;
                break;
            case(12):
                itemName = "Computer Mouse";
                roomNumber = 4;
                break;
            case(13):
                itemName = "Electrical Panel";
                roomNumber = 1;
                isCarryAble = 0;
                break;
            case(14):
                itemName = "Safe";
                roomNumber = 3;
                isCarryAble = 0;
                break;
            case(15):
                itemName = "Key";
                roomNumber = 3;
                break;
            case(16):
                itemName = "Beer Crate";
                roomNumber = 6;
                isCarryAble = 0;
                break;
            default:
        }
        try {
            img = ImageIO.read(new File("src/main/resources/items/" + itemName + ".png"));
            img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Image getImg() {
        return img;
    }

    public int getItemNumber() { return itemNumber; }

    public int getIsCarryAble() {
        return isCarryAble;
    }

    public String getItemName() {
        return itemName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void itemUsage() {

    }
}
