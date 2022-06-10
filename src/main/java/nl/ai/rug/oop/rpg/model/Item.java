package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
                itemName = "hat";
                roomNumber = 2;
                coords.put("x", 360);
                coords.put("y", 150);
            case(1):
                itemName = "euro";
                coords.put("x", 380);
                coords.put("y", 50);
                roomNumber = 0;
                break;
            case(2):
                itemName = "phone";
                roomNumber = 3;
                coords.put("x", 380);
                coords.put("y", 50); //todo change
                isCarryAble = 0;
                break;
            case(3):
                itemName = "coffee";
                roomNumber = 1;
                coords.put("x", 230);
                coords.put("y", 210);
                break;
            case(4):
                itemName = "cleaning-supplies";
                roomNumber = 0;
                coords.put("x", 70);
                coords.put("y", 270);
                break;
            case(5):
                itemName = "flashlight";
                roomNumber = 3;
                coords.put("x", 170);
                coords.put("y", 270); //todo change
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
                itemName = "hammer";
                roomNumber = 1;
                coords.put("x", 710);
                coords.put("y", 280);
                break;
            case(9):
                itemName = "Locked desk";
                roomNumber = 4;
                isCarryAble = 0;
                break;
            case(10):
                itemName = "screwdriver";
                roomNumber = 2;
                coords.put("x", 450);
                coords.put("y", 400);
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
                itemName = "electrical-panel";
                roomNumber = 1;
                isCarryAble = 0;
                coords.put("x", 360);
                coords.put("y", 150);
                break;
            case(14):
                itemName = "safe";
                roomNumber = 3;
                isCarryAble = 0;
                coords.put("x", 360);
                coords.put("y", 150); //todo change
                break;
            case(15):
                itemName = "key";
                roomNumber = 3;
                coords.put("x", 360);
                coords.put("y", 150); //todo change
                break;
            case(16):
                itemName = "Beer Crate";
                roomNumber = 6;
                isCarryAble = 0;
                break;
            default:
        }
        /*try {
            img = ImageIO.read(new File("src/main/resources/items/" + itemName + ".png"));
            img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }*/
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
    private final HashMap<String, Integer> coords = new HashMap<>(); // note from teo: i needed this, but you still need to set them in the constructor (and in game). try coords.put("x", value);
    public HashMap<String, Integer> getCoords() {
        return coords;
    }
}
