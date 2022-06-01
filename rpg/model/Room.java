package nl.rug.ai.rpg.model;

import java.util.*;

public class Room {
    public final int roomNumber;
    private List<Item> roomItems = new ArrayList<>();
    private List<NPC> NPCs = new ArrayList<>();
    private int[] roomConnections;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomConnections() {}

    public int[] getRoomConnections() {return roomConnections; }

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
}
