package nl.ai.rug.oop.rpg.model;

import java.util.ArrayList;
import java.util.HashMap;

public class NPCDialogue {

    private HashMap<Integer, String> dialogueMap = new HashMap<>();
    private int currentKey = 0; // teo

    public void setLine(int key) {
        currentKey = key;
    }
    public NPCDialogue(int NPCnumber, int dialoguetype) {
        switch (NPCnumber) {
            case(0):
                stacey();
                break;
            case(1):
                sam();
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

    private void stacey(){
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Thanks so much for helping me. I really need to find this beer, or else the party will be a disaster!");
        dialogueMap.put(2, "You can look anywhere in the dorm to find it, but you’ll first need approval to enter anyone’s bedroom – we take privacy seriously here. So make sure you ask before entering! You can obviously go into mine straight away.");
        dialogueMap.put(3, "You should start by talking to Davey. He is always hanging out in the living room. Maybe he saw something? In the meantime,  I'll make a batch of coffee for you. Cops like that, right?");
        dialogueMap.put(4, "If you want any other information about the place or my housemates, just let me know!");

        /* Second interaction dialogue (After getting hat) */
        dialogueMap.put(11, "Hey, still making that coffee! did you find the beer yet?");
        //TODO insert detective lines
        dialogueMap.put(12, "Oh… well, I don’t really know what else to say to you…");

        /* Third interaction dialogue (After interaction with phone/coffee finished) */
        dialogueMap.put(21, "Hey, that coffee should be ready! did you find the beer yet?");
        dialogueMap.put(22, "Oh… well, I don’t really know what else to say to you…");

        /* Fourth interaction dialogue (After watching video) */
        dialogueMap.put(31, "Hey, that coffee should be ready! did you find the beer yet?");
        //TODO insert detective lines
        dialogueMap.put(32, "Oh, yeah, that… That happens from time to time. But it was really nothing.");
        //TODO insert detective lines
        dialogueMap.put(33, "Well, it was really silly. So we planned the party together, right? For both of our graduations!");
        dialogueMap.put(34, "But when I invited people, I accidentally wrote that it was a party for MY graduation. I honestly just missed it, I didn’t mean to frame it like this.");
        //TODO insert detective lines
        dialogueMap.put(35, "What? Spite?! No, never… Sammi and I have been so excited for this day forever, she would never.");

        /* Fifth/Final interaction dialogue (After finding crate) */
        dialogueMap.put(41, "Hey, that coffee should be ready! did you find the beer yet?");
        //TODO insert detective lines
        dialogueMap.put(42, "What?! Who did it?");
        //TODO insert detective lines
        dialogueMap.put(43, "I can’t believe this…");
        //TODO insert detective lines
        dialogueMap.put(44, "Thank you very much!");
    }

    private void sam() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Hey! You’re the cop, right? To find the beer?");
        //TODO insert detective lines
        dialogueMap.put(2, "Oh, well I really hope you find it, our party will be ruined otherwise. And it’s both our graduations, Stacey and me.");
    }

    private void davey1(){
        /* First interaction dialogue (Start of game) */
        //TODO insert detective lines
        dialogueMap.put(1, "… Oh, are you talking to me?");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(2, "Oh my bad dude, my ears are sometimes wack. I love your kind vibes bro. Yeah, I’m Davey, what’s good?");
        //TODO insert detective lines
        dialogueMap.put(3, "Oh what, there was beer?");
        //TODO insert detective lines
        dialogueMap.put(4, "Oh what, there was a party?");
        //TODO insert detective lines
        dialogueMap.put(5, "Oh, what? Woah… That’s messed up dude… Wait...");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(6, "Have you seen my hat? I’m missing my hat…");

        /* Second interaction dialogue (After first interaction has ended once) */
        dialogueMap.put(11, "Where’s my hat…");

        /* Third interaction dialogue (After finding hat) */
        dialogueMap.put(21, "Awe, dude, my hat! Thanks.");
        //TODO insert detective lines
        dialogueMap.put(22, "Oh you need to get into my room? yeah of course that's cool bro, you don’t need to ask…");
        dialogueMap.put(23, "Wait… where’s my phone?");

        /* Fourth interaction dialogue (After interacting with phone) */
        dialogueMap.put(31, "Awe, dude, my phone! you are like a detective God, dude.");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(32, "Wow, hombre… careful for this hostility. It will like, reduce your years, or something. I can explain…");
        dialogueMap.put(33, "Oh, mi amigo. I can see how that makes me look bad, but I can explain…");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(34, "Listen here's the truth. I don't have so much money, I keep, uh,  spending it on, uh… groceries. So I thought maybe I could swap the beer for some … groceries.");
        dialogueMap.put(35, "But by the time I looked inside the fridge, the beer was like, gone, dude. Like, not there. someone had already taken it, and by someone,  I mean not me.");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(36 ,"I can prove it. Melvin keeps a camera outside his door, right? That camera can show that I never left the living room, the whole day.");
        //TODO insert detective lines
        dialogueMap.put(37, "There's a secret door knock Melvin has to know you're cool, and then you can enter the room. I know the knock.");
        //TODO insert detective lines
        dialogueMap.put(38, "Well, like I can tell you it. But first, I need some, uh, money. For, uh, groceries…");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(39, "Haaa, cool. Wait, what did I just say? …");

        /* Fifth interaction dialogue (After giving money) */
        dialogueMap.put(41, "Right on bro, that’s chill. Here’s the secret knock! You’ll see that the video totally like exonerates me bro.");
        dialogueMap.put(42, "You'll need a flashlight though, man his room is dark!");
        dialogueMap.put(43, "Oh my flashlight… that must be in my room. It’s pretty messy though… someone should clean it…");

        /* Sixth/Final interaction dialogue (After getting flashlight) */
        dialogueMap.put(51, "I told you I didn’t do it. I don’t think I can really help you further bro. Cough cough cough…");
    }

    private void davey2() {
        /* First interaction dialogue (Start of game) */
        //TODO insert detective lines
        dialogueMap.put(1, "… Oh, are you talking to me?");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(2, "Oh my bad dude, your energy was just offputting my dawg. All good though. Yeah, I’m Davey, what’s good?");
        //TODO insert detective lines
        dialogueMap.put(3, "Oh what, there was beer?");
        //TODO insert detective lines
        dialogueMap.put(4, "Oh what, there was a party?");
        //TODO insert detective lines
        dialogueMap.put(5, "Oh, what? Woah… That’s messed up dude… Wait...");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(6, "Have you seen my hat? I’m missing my hat…");

        /* Second interaction dialogue (After first interaction has ended once) */
        dialogueMap.put(11, "Where’s my hat…");

        /* Third interaction dialogue (After finding hat) */
        dialogueMap.put(21, "Awe, dude, my hat! Thanks.");
        //TODO insert detective lines
        dialogueMap.put(22, "Oh you need to get into my room? yeah of course that's cool bro, you don’t need to ask…");
        dialogueMap.put(23, "Wait… where’s my phone?");

        /* Fourth interaction dialogue (After interacting with phone) */
        dialogueMap.put(31, "Awe, dude, my phone! you are like a detective God, dude.");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(32, "Wow, hombre… careful for this hostility. It will like, reduce your years, or something. I can explain…");
        dialogueMap.put(33, "Oh, mi amigo. I can see how that makes me look bad, but I can explain…");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(34, "Listen here's the truth. I don't have so much money, I keep, uh,  spending it on, uh… groceries. So I thought maybe I could swap the beer for some … groceries.");
        dialogueMap.put(35, "But by the time I looked inside the fridge, the beer was like, gone, dude. Like, not there. someone had already taken it, and by someone,  I mean not me.");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(36 ,"I can prove it. Melvin keeps a camera outside his door, right? That camera can show that I never left the living room, the whole day.");
        //TODO insert detective lines
        dialogueMap.put(37, "There's a secret door knock Melvin has to know you're cool, and then you can enter the room. I know the knock.");
        //TODO insert detective lines
        dialogueMap.put(38, "Well, like I can tell you it. But first, I need some, uh, money. For, uh, groceries…");
        //TODO insert detective lines --> X/Y difference
        dialogueMap.put(39, "Haaa, cool. Wait, what did I just say? …");

        /* Fifth interaction dialogue (After giving money) */
        dialogueMap.put(41, "Right on bro, that’s chill. Here’s the secret knock! You’ll see that the video totally like exonerates me bro.");
        dialogueMap.put(42, "You'll need a flashlight though, man his room is dark!");
        dialogueMap.put(43, "Oh my flashlight… that must be in my room. It’s pretty messy though… someone should clean it…");

        /* Sixth/Final interaction dialogue (After getting flashlight) */
        dialogueMap.put(51, "I told you I didn’t do it. I don’t think I can really help you further bro. Cough cough cough…");
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
        //dialogue.add("Can I help you?");
        //dialogue.add("I usually don’t talk with Cops, let alone help them.");
        //dialogue.add("It’s somewhere around here. Find it yourself.");
    }

    public HashMap<Integer, String> getDialogueMap() {
        return dialogueMap;
    }

    public String getDialogue(int n){
        if (dialogueMap.get(n) != null) {
            return dialogueMap.get(n);
        } else {
            return null;
        }
    }
}
