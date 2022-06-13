package nl.ai.rug.oop.rpg.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @Author Daniël
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
        if(roomNumber <= 2){
            isOpen = true;
        } else {
            isOpen = false;
        }
    }

    public void addRoomItem(Item item) {
        roomItems.add(item);
        System.out.println("Added " + item.getItemName());
    }
    public void removeRoomItem(Item item) { roomItems.remove(item); }

    public Item getRoomItem(int itemNumber) {
        for (int i = 0; i < roomItems.size(); i++) {
            if (roomItems.get(i).getItemNumber() == itemNumber) {
                return roomItems.remove(i);
            }
        }
        return null;
    }

    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    public NPC getNPC() {
        return npc;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Image getImg() {
        return img;
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }
}
