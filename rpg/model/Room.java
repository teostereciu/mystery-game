package nl.rug.ai.rpg.model;

import java.util.*;

public class Room {
    public final int roomNumber;
    private ArrayList<Item> roomItems

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomItems(ArrayList<Item> roomItems) {
        this.roomItems = roomItems;
    }

}
