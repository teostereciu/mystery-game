package nl.ai.rug.oop.rpg.model;

public class NPCDialogue {
    public NPCDialogue(int NPCnumber, int dialoguetype) {
        switch (NPCnumber) {
            case(0):
                if (dialoguetype == 0) {
                    stacey1();
                } else {
                    stacey2();
                }
                break;
            case(1):
                if (dialoguetype == 0) {
                    sam1();
                } else {
                    sam2();
                }
                break;
            case(2):
                if (dialoguetype == 0) {
                    davey1();
                } else {
                    davey2();
                }
                break;
            case(3):
                if (dialoguetype == 0) {
                    melvin1();
                } else {
                    melvin2();
                }
                break;
            case(4):
                if (dialoguetype == 0) {
                    alex1();
                } else {
                    alex2();
                }
                break;
            case(5):
                if (dialoguetype == 0) {
                    kyle1();
                } else {
                    kyle2();
                }
                break;
        }
    }

    private void stacey1(){

    }

    private void stacey2() {

    }

    private void sam1() {

    }

    private void sam2(){

    }

    private void davey1(){

    }

    private void davey2() {

    }

    private void kyle1() {

    }

    private void kyle2() {

    }

    private void alex1() {

    }

    private void alex2() {

    }

    private void melvin1() {

    }

    private void melvin2() {

    }
}
