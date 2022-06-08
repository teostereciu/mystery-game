package nl.ai.rug.oop.rpg.model;
import java.io.*;
import java.util.*;
/**
 * @Author Daniël
 */
public class Inventory {
    private ArrayList<Item> inventoryItems = new ArrayList<>();
    private int totalInventorySlots;
    private int inventorySlotsFull[];
    //Make sure the items stay in the same positions so that that item position in the inventory clears up

    public Inventory(int totalInventorySlots){
        this.totalInventorySlots = totalInventorySlots;
        inventorySlotsFull = new int[totalInventorySlots];
        for (int i = 0; i < totalInventorySlots; i++) {
            inventorySlotsFull[i] = 0;
            inventoryItems = null;
        }
    }

    public void addToInventory (Item item) {
        for (int i = 0; i < totalInventorySlots; i++) {
            if (inventorySlotsFull[i] == 0) {
                inventoryItems.set(i, item);
                inventorySlotsFull[i] = 1;
            } else {
                //Give inventory is full message
            }
        }
    }

    public Item removeFromInventory(int itemNumber) {
        for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getItemNumber() == itemNumber) {
                Item item = inventoryItems.get(i);
                inventoryItems.set(i, null);
                inventorySlotsFull[i] = 0;
                return item;
            }
        }
        return null;
    }
}
