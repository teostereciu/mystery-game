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
    private int isOpen;
    private Image img;

    /**
     * Creates a new instance of the object Room
     * @param roomNumber shows which room it is
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        isOpen = 0; //TODO set some rooms open and some closed
        try {
            img = ImageIO.read(new File("src/main/resources/rooms/room" + roomNumber + ".png"));
            img = img.getScaledInstance(1067, 600, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    /**
     * Adds an item to the room
     * @param item = the item to be added
     */
    public void addRoomItem(Item item) {
        roomItems.add(item);
    }

    /**
     * removes an item from the room
     * @param itemNumber = number of item to be removed
     * @return the removed item if present, else null
     */
    public Item getRoomItem(int itemNumber) {
        for (int i = 0; i < roomItems.size(); i++) {
            if (roomItems.get(i).getItemNumber() == itemNumber) {
                return roomItems.remove(i);
            }
        }
        return null;
    }

    /**
     * Sets the npc for the room
     * @param npc = npc to be set
     */
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    /**
     * @return the npc of the room
     */
    public NPC getNPC() {
        return npc;
    }

    /**
     * @return whether it is already possible to enter the room (1) or not (0)
     */
    public int getIsOpen() {
        return isOpen;
    }

    /**
     * Updates the room to be open or not
     * @param isOpen = value of open (1) or not (0) for the room
     */
    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * @return the image of the room
     */
    public Image getImg() {
        return img;
    }

    /**
     * @return the list of items present in the room
     */
    public List<Item> getRoomItems() {
        return roomItems;
    }
}
