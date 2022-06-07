package nl.ai.rug.oop.rpg.model;
/**
 * @Author Daniël
 */
public class Item {
    private String itemName;
    private final int itemNumber; //is also NPC coupling number
    private int isCarryAble;
    private int canPickUp;
    private int roomNumber;


    public Item(int itemNumber){
        this.itemNumber = itemNumber;
        switch (itemNumber) {
            case(0):
                break;
            case(1):
                break;
            case(2):
                break;
            case(3):
                break;
            case(4):
                break;
            case(5):
                break;
            case(6):
                break;
            case(7):
                break;
        }
    }

    public int getItemNumber() {return itemNumber; }

    public int getRoomNumber() {
        return roomNumber;
    }

}
