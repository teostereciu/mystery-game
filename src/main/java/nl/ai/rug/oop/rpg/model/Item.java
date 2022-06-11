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
    private int progressNPCnumber;

    //todo change names of items to the file names
    //todo couple progressNPCnumber to item

    /**
     * Creates an instance of the object Item
     * The object is given multiple functionalities when build
     * @param itemNumber the number coupled to the item
     */
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
                coords.put("x", 90);
                coords.put("y", 400);
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
                coords.put("x", 150);
                coords.put("y", 380);
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
                coords.put("x", 100);
                coords.put("y", 245);
                break;
            case(15):
                itemName = "key";
                roomNumber = 3;
                coords.put("x", 100);
                coords.put("y", 350); //todo change
                break;
            case(16):
                itemName = "Beer Crate";
                roomNumber = 6;
                isCarryAble = 0;
                break;
            default:
        }
    }

    /**
     * @return the number of the item
     */
    public int getItemNumber() { return itemNumber; }

    /**
     * @return whether the player should be able to pick up the item (1) or not (0)
     */
    public int getIsCarryAble() {
        return isCarryAble;
    }

    /**
     * @return the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the room the item is coupled to
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Whenever an item is used/interacted, should check if NPCs are progressed
     * @return progressNPCnumber = the number of the NPC that is progressed by using the item
     */
    public int itemUsage() {
        return progressNPCnumber;
    }
    private final HashMap<String, Integer> coords = new HashMap<>(); // note from teo: i needed this, but you still need to set them in the constructor (and in game). try coords.put("x", value);
    public HashMap<String, Integer> getCoords() {
        return coords;
    }
}
