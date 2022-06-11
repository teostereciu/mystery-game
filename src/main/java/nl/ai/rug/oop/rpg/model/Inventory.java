package nl.ai.rug.oop.rpg.model;

import java.io.*;
import java.util.*;
/**
 * @Author Daniël
 */
public class Inventory {
    public ArrayList<Item> getItemsArray() {
        return inventoryItems;
    }
    private ArrayList<Item> inventoryItems = new ArrayList<>();
    private final int totalInventorySlots;
    private int inventorySlotsFull[];
    //Make sure the items stay in the same positions so that that item position in the inventory clears up

    public Inventory(int totalInventorySlots){
        this.totalInventorySlots = totalInventorySlots;
        inventorySlotsFull = new int[totalInventorySlots];
        /*for (int i = 0; i < totalInventorySlots; i++) {
            inventorySlotsFull[i] = 0;
            inventoryItems = null;
        }*/
    }

    public boolean isFull() {
        return inventoryItems.size() == totalInventorySlots;
    }

    public int addToInventory (Item item) {
        if (!isFull()) {
            inventoryItems.add(item);
            return 1;
        } else {
            return 0;
        }
    }

    public void removeFromInventory(Item item) {
        inventoryItems.remove(item);
        /*for (int i = 0; i < inventoryItems.size(); i++) {
            if (inventoryItems.get(i).getItemNumber() == itemNumber) {
                Item item = inventoryItems.get(i);
                inventoryItems.set(i, null);
                inventorySlotsFull[i] = 0;
                return item;
            }
        }
        return null;*/
    }
}
