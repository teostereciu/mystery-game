package nl.ai.rug.oop.rpg.model;
/**
 * @Author Daniël
 */
public class NPC {
    private int NPCNumber;
    private String NPCname;
    private int roomNumber;

    public NPC(int number){
        switch (number) {
            case (0) -> this.Stacey();
            case (1) -> this.Samantha();
            case (2) -> this.Davey();
            case (3) -> this.Melvin();
            case (4) -> this.Alex();
            case (5) -> this.Kyle();
            default -> {
            }
        }

    }
    private void Stacey() {
        NPCNumber = 0;
        NPCname = "Stacey";
        roomNumber = 0;
    }
    private void Samantha() {
        NPCNumber = 1;
        NPCname = "Samantha";
        roomNumber = 2;
    }
    private void Davey() {
        NPCNumber = 2;
        NPCname = "Davey";
        roomNumber = 1;
    }
    private void Melvin() {
        NPCNumber = 3;
        NPCname = "Melvin";
        roomNumber = 5;
    }
    private void Alex() {
        this.NPCNumber = 4;
        this.NPCname = "Alex";
        roomNumber = 4;
    }
    private void Kyle() {
        this.NPCNumber = 5;
        this.NPCname = "Kyle";
        roomNumber = 3;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
