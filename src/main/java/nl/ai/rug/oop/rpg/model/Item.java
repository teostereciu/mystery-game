package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for the Item object
 * The usage of items progresses NPC dialogue and the game overall
 * @Author Dancoko
 */
public class Item {
    private String itemName;
    private final int itemNumber;
    private int isCarryAble;
    private int roomNumber;
    private int isPlayable;
    private int isAvailable;

    /**
     * Constructs a new instance of the item object
     * with each item having certain pre-programmed values
     * @param itemNumber is the number of the item
     */
    public Item(int itemNumber){
        this.itemNumber = itemNumber;
        isCarryAble = 1;
        isAvailable = 1;
        isPlayable = 0;
        switch (itemNumber) {
            case(0):
                isPlayable = 1;
                itemName = "hat";
                roomNumber = 2;
                coords.put("x", 500);
                coords.put("y", 180);
                break;
            case(1):
                itemName = "phone";
                roomNumber = 3;
                coords.put("x", 90);
                coords.put("y", 400);
                isCarryAble = 0;
                break;
            case(2):
                itemName = "euro";
                roomNumber = 0;
                coords.put("x", 380);
                coords.put("y", 50);
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
                itemName = "camera";
                roomNumber = 5;
                coords.put("x", 550);
                coords.put("y", 300);
                break;
            case(7):
                itemName = "computer";
                roomNumber = 4;
                isCarryAble = 0;
                coords.put("x", 550);
                coords.put("y", 250);
                break;
            case(8):
                itemName = "hammer";
                roomNumber = 1;
                coords.put("x", 710);
                coords.put("y", 280);
                break;
            case(9):
                itemName = "locked-drawer";
                roomNumber = 4;
                isCarryAble = 0;
                coords.put("x", 350);
                coords.put("y", 230);
                break;
            case(10):
                itemName = "screwdriver";
                roomNumber = 2;
                coords.put("x", 450);
                coords.put("y", 400);
                break;
            case(11):
                itemName = "scissors";
                roomNumber = 4;
                coords.put("x", 450);
                coords.put("y", 300);
                isAvailable = 0;
                break;
            case(12):
                itemName = "mouse";
                roomNumber = 4;
                coords.put("x", 250);
                coords.put("y", 400);
                isAvailable = 0;
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
                coords.put("y", 350);
                isAvailable = 0;
                break;
            case(16):
                itemName = "crate";
                roomNumber = 6;
                isCarryAble = 0;
                coords.put("x", 100);
                coords.put("y", 350);
                break;
            default:
        }
    }

    /**
     * @return the number of an item
     */
    public int getItemNumber() { return itemNumber; }

    /**
     * @return the name of an item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the set roomNumber of an item
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @return whether the player should be able to pick up item (1) or not (0)
     */
    public int getIsCarryAble() {
        return isCarryAble;
    }

    /**
     * @return whether the player should be able to see the item (1) or not (0)
     */
    public int getIsAvailable() {
        return isAvailable;
    }

    /**
     * Change the availability status of the item
     * @param isAvailable is 1 if should become available and 0 if unavailable
     */
    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return whether the player should be able to play the item (1) or not (0)
     */
    public int getIsPlayable() {
        return isPlayable;
    }

    /**
     * Change the playability status of the item
     * @param isPlayable is 1 if should become playable and 0 if unplayable
     */
    public void setIsPlayable(int isPlayable) {
        this.isPlayable = isPlayable;
    }

    /**
     * Contains the coords the item should be placed on in the view
     */
    private final HashMap<String, Integer> coords = new HashMap<>();

    /**
     * @return the coords linked to the item
     */
    public HashMap<String, Integer> getCoords() {
        return coords;
    }
}
