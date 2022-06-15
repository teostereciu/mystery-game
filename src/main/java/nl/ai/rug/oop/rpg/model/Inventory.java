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

    public Inventory(int totalInventorySlots) {
        this.totalInventorySlots = totalInventorySlots;
    }

    public boolean isFull() {
        return inventoryItems.size() == totalInventorySlots;
    }

    public int addToInventory(Item item) {
        if (!isFull()) {
            inventoryItems.add(item);
            return 1;
        } else {
            return 0;
        }
    }

    public void removeFromInventory(Item item) {
        inventoryItems.remove(item);
    }

}
