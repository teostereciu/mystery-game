package nl.ai.rug.oop.rpg.model;

public class NPC {
    private int NPCNumber;

    public NPC(String name){
        switch (name) {
            case("Stacey"):
                this.Stacey();
                break;
            case("Samantha"):
                this.Samantha();
                break;
            case("Davey"):
                this.Davey();
                break;
            case("Melvin"):
                this.Melvin();
                break;
            case("Alex"):
                this.Alex();
                break;
            case("Kyle"):
                this.Kyle();
                break;
            default:

        }

    }
    private void Stacey() {
        this.NPCNumber = 0;
    }
    private void Samantha() {
        this.NPCNumber = 1;
    }
    private void Davey() {
        this.NPCNumber = 2;
    }
    private void Melvin() {
        this.NPCNumber = 3;
    }
    private void Alex() {
        this.NPCNumber = 4;
    }
    private void Kyle() {
        this.NPCNumber = 5;
    }
}
