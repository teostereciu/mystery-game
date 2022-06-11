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
    }

    public boolean isFull() {
        return inventoryItems.size() == totalInventorySlots;
    }

    public void addToInventory (Item item) {
        //for (int i = 0; i < totalInventorySlots; i++) {
        //if (inventorySlotsFull[i] == 0) {
        //if (!isFull()) {
        inventoryItems.add(item);
    }

    public void removeFromInventory(Item item) {
        inventoryItems.remove(item);
    }
}
