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
        isOpen = 0;
        try {
            img = ImageIO.read(new File("src/main/resources/rooms/room" + roomNumber + ".png"));
            img = img.getScaledInstance(1067, 600, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public void addRoomItem(Item item) {
        roomItems.add(item);
    }
    public void removeRoodItem(Item item) { roomItems.remove(item); }

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

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public Image getImg() {
        return img;
    }

    public List<Item> getRoomItems() {
        return roomItems;
    }
}
