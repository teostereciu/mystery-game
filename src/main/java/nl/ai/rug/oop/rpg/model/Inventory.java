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

    /**
     * Constructor for the inventory. Sets all slots to 0
     * @param totalInventorySlots = total amount of inventory slots possible as decided by the view
     */
    public Inventory(int totalInventorySlots){
        this.totalInventorySlots = totalInventorySlots;
        inventorySlotsFull = new int[totalInventorySlots];
        for (int i = 0; i < totalInventorySlots; i++) {
            inventorySlotsFull[i] = 0;
            inventoryItems = null;
        }
    }

    /**
     * Adds an item to the inventory
     * @param item = item to be added to inventory
     * @return which inventory slot the item is added to
     */
    public int addToInventory (Item item) {
        for (int i = 0; i < totalInventorySlots; i++) {
            if (inventorySlotsFull[i] == 0) {
                inventoryItems.set(i, item);
                inventorySlotsFull[i] = 1;
                return i;
            }
        }
        return -1;
    }

    /**
     * removes an item from the inventory if it is used
     * @param itemNumber number of item to be removed
     * @return the item
     */
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
