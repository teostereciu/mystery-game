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
    private int isPlayable;
    private int isAvailable;

    //todo change names of items to the file names
    //TODO give the items functions
    //TODO couple the item functions to NPCs
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
                coords.put("x", 450);
                coords.put("y", 380);
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
                itemName = "locked-drawer"; // note changed from desk. todo change in dialogue
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
                coords.put("y", 300); //todo change
                isAvailable = 0;
                break;
            case(12):
                itemName = "mouse";
                roomNumber = 4;
                coords.put("x", 250);
                coords.put("y", 400); //todo change
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
                coords.put("y", 350); //todo change
                isAvailable = 0;
                break;
            case(16):
                itemName = "crate";
                roomNumber = 6;
                isCarryAble = 0;
                coords.put("x", 100);
                coords.put("y", 350); //todo change
                break;
            default:
        }
    }

    public int getItemNumber() { return itemNumber; }

    public String getItemName() {
        return itemName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getIsCarryAble() {
        return isCarryAble;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getIsPlayable() {
        return isPlayable;
    }

    public void setIsPlayable(int isPlayable) {
        this.isPlayable = isPlayable;
    }

    private final HashMap<String, Integer> coords = new HashMap<>();
    public HashMap<String, Integer> getCoords() {
        return coords;
    }
}
