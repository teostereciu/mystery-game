package nl.ai.rug.oop.rpg.model;

import java.util.*;

/**
 * @Author Daniël
 */
public class Room {
    public final int roomNumber;
    private List<Item> roomItems = new ArrayList<>();
    private List<NPC> NPCs = new ArrayList<>();
    private int isOpen;

    /**
     * Creates a new instance of the object Room
     * @param roomNumber shows which room it is
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        isOpen = 0;
    }

    public void setRoomItems(ArrayList<Item> roomItems) {
        this.roomItems = roomItems;
    }

    public void addRoomItem(Item item) {
        roomItems.add(item);
    }

    public Item getRoomItem(int index) {
        return roomItems.remove(index);
    }

    public void setNPCs(ArrayList<NPC> NPCs) {this.NPCs = NPCs; }

    public void addNPC(NPC npc) {
        NPCs.add(npc);
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }
}
