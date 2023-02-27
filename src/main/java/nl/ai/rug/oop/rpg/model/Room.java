package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Class for the Room object.
 * It holds items and npcs and different rooms show different views.
 * @Author Dancoko
 */
public class Room {
    public final int roomNumber;
    private List<Item> roomItems = new ArrayList<>();
    private NPC npc;
    private boolean isOpen;
    private Image img;

    /**
     * Creates a new instance of the object Room
     * @param roomNumber shows which room it is
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        isOpen = roomNumber <= 2;
    }

    /**
     * Adds an item to the room object
     * @param item to be added to the room
     */
    public void addRoomItem(Item item) {
        roomItems.add(item);
    }

    /**
     * Removes an item from the room object
     * @param item to be removed from the room
     */
    public void removeRoomItem(Item item) { roomItems.remove(item); }

    /**
     * Sets an NPC in the room
     * @param npc to be coupled to the room
     */
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    /**
     * @return the NPC that is coupled to the room
     */
    public NPC getNPC() {
        return npc;
    }

    /**
     * @return whether the room is open/accessible for the player (1) or not (0)
     */
    public boolean getIsOpen() {
        return isOpen;
    }

    /**
     * Sets the accessibility of the room
     * @param isOpen sets the room accessible (1) or unaccessible (0)
     */
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * @return the list of items located in the room
     */
    public List<Item> getRoomItems() {
        return roomItems;
    }
}
