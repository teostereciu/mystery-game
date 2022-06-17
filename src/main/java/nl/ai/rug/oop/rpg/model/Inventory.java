package nl.ai.rug.oop.rpg.model;

import java.io.*;
import java.util.*;
/**
 * Class for the Inventory object.
 * It holds multiple instances of the Item object
 * @Author Dancoko
 */
public class Inventory {
    private ArrayList<Item> inventoryItems = new ArrayList<>();
    private final int totalInventorySlots;

    public Inventory(int totalInventorySlots) {
        this.totalInventorySlots = totalInventorySlots;
    }

    public boolean isFull() {
        return inventoryItems.size() == totalInventorySlots;
    }

    /**
     * Stores a given item into the inventory
     * @param item is the item to be stored into the inventory
     * @return 1 if succesful storage, 0 if not succesful (inventory is full)
     */
    public int addToInventory(Item item) {
        if (!isFull()) {
            inventoryItems.add(item);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * @return the ArrayList of inventoryItems
     */
    public ArrayList<Item> getItemsArray() {
        return inventoryItems;
    }

    /**
     * Removes an item from the inventory
     * @param item the item to be removed
     */
    public void removeFromInventory(Item item) {
        inventoryItems.remove(item);
    }

}
