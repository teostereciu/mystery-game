package nl.ai.rug.oop.rpg.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for the NPCDialogue object which represents the dialogue given by and with NPCs
 * @author Dancoko
 */
public class NPCDialogue {

    private HashMap<Integer, String> dialogueMap = new HashMap<>();
    private int currentKey = 0;

    /**
     * Sets the key to a passed value
     * @param key is the key for entering the hashmap
     */
    public void setCurrentKey(int key) {
        currentKey = key;
    }

    /**
     * Increases the line of the dialogue and resets it if it passes the threshold
     */
    public void increaseLine() {
        currentKey++;
        if (currentKey%100 == 0) {
            currentKey = 0;
        }
    }

    /**
     * Initializes the dialogue
     * @param NPCnumber is the number of a corresponding npc
     * @param dialoguetype is 0 if the player is playing as the good cop, otherwise 1
     */
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
                kyle();
                break;
        }
    }

    /**
     * Initialises the dialogue for Stacey
     */
    private void stacey(){
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Stacey: Thanks so much for helping me. I really need to find this beer, or else the party will be a disaster!");
        dialogueMap.put(2, "Stacey: You can look anywhere in the dorm to find it, but you’ll first need approval to enter anyone’s bedroom.");
        dialogueMap.put(3, "Stacey: We take privacy seriously here. So make sure you ask before entering! You can obviously go into mine straight away.");
        dialogueMap.put(4, "Stacey: You should start by talking to Davey. He is always hanging out in the kitchen. Maybe he saw something?");
        dialogueMap.put(5, "Stacey: In the meantime, I'll make a batch of coffee for you. Cops like that, right?");
        dialogueMap.put(6, "Stacey: If you want any other information about the place or my housemates, just let me know!");
        dialogueMap.put(7, "END");

        /* Second interaction dialogue (After getting hat) */
        dialogueMap.put(101, "Stacey: Hey, still making that coffee! did you find the beer yet?");
        dialogueMap.put(102, "Detective: No, not yet.");
        dialogueMap.put(103, "Stacey: Oh… well, I don’t really know what else to say to you…");
        dialogueMap.put(104, "END");

        /* Third interaction dialogue (After interaction with phone/coffee finished) */
        dialogueMap.put(201, "Stacey: Hey, that coffee should be ready! did you find the beer yet?");
        dialogueMap.put(202, "Detective: No, not yet.");
        dialogueMap.put(203, "Stacey: Oh… well, I don’t really know what else to say to you…");
        dialogueMap.put(204, "END");

        /* Fourth interaction dialogue (After watching video) */
        dialogueMap.put(301, "Stacey: Hey, that coffee should be ready! did you find the beer yet?");
        dialogueMap.put(302, "Detective: I heard that you and Samantha had a fight this morning?");
        dialogueMap.put(303, "Stacey: Oh, yeah, that… That happens from time to time. But it was really nothing.");
        dialogueMap.put(304, "Detective: What happened?");
        dialogueMap.put(305, "Stacey: Well, it was really silly. So we planned the party together, right? For both of our graduations!");
        dialogueMap.put(306, "Stacey: But when I invited people, I accidentally wrote that it was a party for MY graduation.");
        dialogueMap.put(307, "Stacey: I honestly just missed it, I didn’t mean to frame it like this.");
        dialogueMap.put(308, "Detective: I see… and you don’t think she could’ve stolen the beer out of spite?");
        dialogueMap.put(309, "Stacey: What? Spite?! No, never… Sammi and I have been so excited for this day forever, she would never.");
        dialogueMap.put(310, "Detective: Okay. I’ll keep looking then.");
        dialogueMap.put(311, "END");

        /* Fifth/Final interaction dialogue (After finding crate) */
        dialogueMap.put(401, "Stacey: Hey, that coffee should be ready! did you find the beer yet?");
        dialogueMap.put(402, "Detective: Actually, yes I did. And I solved who found it.");
        dialogueMap.put(403, "Stacey: What?! Who did it?");
        dialogueMap.put(404, "Detective: It was your best friend, Samantha. I think that little fight you guys had didn’t blow over so easy for her. ");
        dialogueMap.put(405, "Detective: She couldn’t handle you having all the attention. She couldn’t lift the crate from the fridge, sure.");
        dialogueMap.put(406, "Detective: But once it was placed in front of the storage room by Alex, she could easily push it inside.");
        dialogueMap.put(407, "Detective: Her bandage must have torn and left a bit while she did so, because I found the bandage right alone with it.");
        dialogueMap.put(408, "Stacey: I can’t believe this…");
        dialogueMap.put(409, "Detective: She didn’t work alone though. Kyle must have opened the door for her. ");
        dialogueMap.put(410, "Detective: Guess he didn’t appreciate that you didn’t invite his friends.");
        dialogueMap.put(411, "Stacey: I will go talk to them. Thank you very much!");
        dialogueMap.put(412, "END");
    }

    /**
     * Initialises the dialogue for Samantha
     */
    private void sam() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Samantha: Hey! You’re the cop, right? To find the beer?");
        dialogueMap.put(2, "Detective: Yeah, that’s me.");
        dialogueMap.put(3, "Samantha: Oh, well I really hope you find it, our party will be ruined otherwise. And it’s both our graduations, Stacey and me.");
        dialogueMap.put(4, "Detective: Can you tell me something about this dorm?");
        dialogueMap.put(5, "Samantha: Well it's a pretty standard student place. Pretty broken down, pretty dirty,  but that's normal here in Groningen.");
        dialogueMap.put(6, "Samantha: There's four bedrooms. I share one with Samantha, and next to us Kyle and Davey also share a room. ");
        dialogueMap.put(7, "Samantha: That means that Melvin and Alex have their own rooms, which is probably for the better!");
        dialogueMap.put(8, "Samantha: Besides that, we have a kitchen, clearly, and we have a living room, which are the shared common areas.");
        dialogueMap.put(9, "Detective: Anything else?");
        dialogueMap.put(10, "Samantha: Oh, right! We also have a storage room, however, that's always locked and can only be opened with a key.");
        dialogueMap.put(11, "Samantha: Kyle has the key, because his dad is the owner of the house.");
        dialogueMap.put(12, "Samantha: We're not really allowed to put much in there, according to Kyle's dad, and whenever we do need something we need the key from Kyle.");
        dialogueMap.put(13, "Detective: Tell me about Alex.");
        dialogueMap.put(14, "Samantha: Alex, she’s, yeah, she’s a nice girl. She kind of takes on a bit of a mom role in the house.");
        dialogueMap.put(15, "Samantha: She’s also dating Kyle, which I think is an interesting match...");
        dialogueMap.put(16, "Samantha: Besides that, she's often studying. I think she has an exam tomorrow - she might be difficult to reach.");
        dialogueMap.put(17, "Detective: How is Kyle?");
        dialogueMap.put(18, "Samantha: Kyle… He’s my SO! The student experience all bundled up in one big frat boy, and look at those muscles!");
        dialogueMap.put(19, "Samantha: He is so strong, he always helps me with everything!");
        dialogueMap.put(20, "Detective: What can you tell about Melvin?");
        dialogueMap.put(21, "Samantha: Yeah, Melvin is quiet. He doesn’t interact with the rest of much… or really at all. ");
        dialogueMap.put(22, "Detective: What kind of person is Davey?");
        dialogueMap.put(23, "Samantha: Yeah Davey is our resident stoner. I don’t think I’ve ever seen anyone smoke so much in my life.");
        dialogueMap.put(24, "Samantha: I also know that he’s pretty much broke because he spends all his money on weed.");
        dialogueMap.put(25, "Detective: How is your relationship with Stacey?");
        dialogueMap.put(26, "Samantha: Oh well Stacey, she's my best friend! We study the same program and when we first met, we connected immediately.");
        dialogueMap.put(27, "Samantha: We also share a room together. She moved into the house because I got her a spot.");
        dialogueMap.put(28, "Samantha: However she can sometimes also be a bit controlling...");
        dialogueMap.put(29, "Samantha: We have our fights sometimes, but what do you expect if you life in the same room?");
        dialogueMap.put(30, "Detective: What do you have on your hand?");
        dialogueMap.put(31, "Samantha: What? Oh yeah the bandage...");
        dialogueMap.put(32, "Samantha: I was cooking for my darling Kyle and myself and I accidently cut myself with a knife.");
        dialogueMap.put(33, "Samantha: It was really stupid.. And now I have to wear this bandage constantly.");
        dialogueMap.put(34, "Samantha: It doesn't even fit me well! Look, it is already tearing of a bit!!");
        dialogueMap.put(35, "Detective: Thank you, I know enough for now.");
        dialogueMap.put(36, "Samantha: If you need anything just ask me!");
        dialogueMap.put(37, "END");
    }

    /**
     * Initialises the good cop dialogue for Davey
     */
    private void davey1(){
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Detective: Hey, are you Davey?");
        dialogueMap.put(2, "Davey: … Oh, are you talking to me?");
        dialogueMap.put(3, "Detective: Yes good sir, I am talking to you.");
        dialogueMap.put(4, "Davey: Oh my bad dude, my ears are sometimes wack. I love your kind vibes bro. Yeah, I’m Davey, what’s good?");
        dialogueMap.put(5, "Detective: Stacey said that you spend most of the day here in the living room. Did you maybe see anyone steal the beer that she had in the fridge?");
        dialogueMap.put(6, "Davey: Oh what, there was beer?");
        dialogueMap.put(7, "Detective: Yes, for the party tonight. You surely are aware of this?");
        dialogueMap.put(8, "Davey: Oh what, there was a party?");
        dialogueMap.put(9, "Detective: Yes, and someone stole the beer. Did you see anything?");
        dialogueMap.put(10, "Davey: Oh, what? Woah… That’s messed up dude… Wait...");
        dialogueMap.put(11, "Detective:  I really need some help here. Would it be possible to get into your room to search for some clues?"); // X/Y difference
        dialogueMap.put(12, "Davey: Have you seen my hat? I’m missing my hat…");
        dialogueMap.put(13, "END");

        /* Second interaction dialogue (After finding hat) */
        dialogueMap.put(101, "Davey: Awe, dude, my hat! Thanks.");
        dialogueMap.put(102, "Detective: Can I go into your room now?");
        dialogueMap.put(103, "Davey: Oh you need to get into my room? yeah of course that's cool bro, you don’t need to ask…");
        dialogueMap.put(104, "Davey: Wait… where’s my phone?");
        dialogueMap.put(105, "END");

        /* Third interaction dialogue (After interacting with phone) */
        dialogueMap.put(201, "Davey: Awe, dude, my phone! you are like a detective God, dude.");
        dialogueMap.put(202, "Detective: Not so fast – this text message that I saw on the front of it doesn’t seem to put you in a good light my friend…");
        dialogueMap.put(203, "Davey: Oh, mi amigo. I can see how that makes me look bad, but I can explain…");
        dialogueMap.put(204, "Detective: I’m on your side, buddy. Tell me the truth."); // X/Y difference
        dialogueMap.put(205, "Davey: Listen here's the truth. I don't have so much money, I keep, uh,  spending it on, uh… groceries.");
        dialogueMap.put(206, "Davey: So I thought maybe I could swap the beer for some… groceries. ut by the time I looked inside the fridge, the beer was like, gone, dude.");
        dialogueMap.put(207, "Davey: Like, not there. someone had already taken it, and by someone, I mean not me.");
        dialogueMap.put(208, "Detective: Is there any way you can corroborate your account?"); // X/Y difference
        dialogueMap.put(209 ,"Davey: I can prove it. Melvin keeps a camera outside his door, right? That camera can show that I never left the living room, the whole day.");
        dialogueMap.put(210, "Detective: Oh yeah, and how do I get through to Melvin? He doesn’t answer his door and doesn’t seem to be talking to anyone here by the sounds of it.");
        dialogueMap.put(211, "Davey: There's a secret door knock Melvin has to know you're cool, and then you can enter the room. I know the knock.");
        dialogueMap.put(212, "Detective: Great! What’s the knock?");
        dialogueMap.put(213, "Davey: Well, like I can tell you it. But first, I need some, uh, money. For, uh, groceries…");
        dialogueMap.put(214, "Detective: Well, if you really need groceries I’ll try and help you out!"); // X/Y difference
        dialogueMap.put(215, "Davey: Haaa, cool. Wait, what did I just say? …");
        dialogueMap.put(216, "END");

        /* Fourth interaction dialogue (After giving money) */
        dialogueMap.put(301, "Davey: Right on bro, that’s chill. Here’s the secret knock! You’ll see that the video totally like exonerates me bro.");
        dialogueMap.put(302, "Davey: You'll need a flashlight though, man his room is dark!");
        dialogueMap.put(303, "Davey: Oh my flashlight… that must be in my room. It’s pretty messy though… someone should clean it…");
        dialogueMap.put(304, "END");

        /* Fifth/Final interaction dialogue (After getting flashlight) */
        dialogueMap.put(401, "Davey: I told you I didn’t do it. I don’t think I can really help you further bro. Cough, cough, cough…");
        dialogueMap.put(402, "END");
    }

    /**
     * Initialises the bad cop dialogue for Davey
     */
    private void davey2() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Detective: Hey, are you Davey?");
        dialogueMap.put(2, "Davey: … Oh, are you talking to me?");
        dialogueMap.put(3, "Detective: Yes moron, clearly there is no one else here."); // X/Y difference
        dialogueMap.put(4, "Davey: Oh my bad dude, your energy was just offputting my dawg. All good though. Yeah, I’m Davey, what’s good?");
        dialogueMap.put(5, "Detective: Stacey said that you spend most of the day here in the living room. Did you maybe see anyone steal the beer that she had in the fridge?");
        dialogueMap.put(6, "Davey: Oh what, there was beer?");
        dialogueMap.put(7, "Detective: Yes, for the party tonight. You surely are aware of this?");
        dialogueMap.put(8, "Davey: Oh what, there was a party?");
        dialogueMap.put(9, "Detective: Yes, and someone stole the beer. Did you see anything?");
        dialogueMap.put(10, "Davey: Oh, what? Woah… That’s messed up dude… Wait...");
        dialogueMap.put(11, "Detective: This is a waste of my time. You better give me approval to enter your room, waster."); // X/Y difference
        dialogueMap.put(12, "Davey: Have you seen my hat? I’m missing my hat…");
        dialogueMap.put(13, "END");

        /* Second interaction dialogue (After finding hat) */
        dialogueMap.put(101, "Davey: Awe, dude, my hat! Thanks.");
        dialogueMap.put(102, "Detective: Can I go into your room now?");
        dialogueMap.put(103, "Davey: Oh you need to get into my room? yeah of course that's cool bro, you don’t need to ask…");
        dialogueMap.put(104, "Davey: Wait… where’s my phone?");
        dialogueMap.put(105, "END");

        /* Third interaction dialogue (After interacting with phone) */
        dialogueMap.put(201, "Davey: Awe, dude, my phone! you are like a detective God, dude.");
        dialogueMap.put(202, "Detective: Cut the crap, buster. I saw this text of you trying to sell the beer! I’ll have you in cuffs!"); // X/Y difference
        dialogueMap.put(203, "Davey: Wow, hombre… careful for this hostility. It will like, reduce your years, or something. I can explain…");
        dialogueMap.put(204, "Detective: Talk."); // X/Y difference
        dialogueMap.put(205, "Davey: Listen here's the truth. I don't have so much money, I keep, uh,  spending it on, uh… groceries.");
        dialogueMap.put(206, "Davey: So I thought maybe I could swap the beer for some… groceries. ut by the time I looked inside the fridge, the beer was like, gone, dude.");
        dialogueMap.put(207, "Davey: Like, not there. someone had already taken it, and by someone, I mean not me.");
        dialogueMap.put(208, "Detective: Bullcrap. Where’s your proof of this fairyful story?"); // X/Y difference
        dialogueMap.put(209 ,"Davey: I can prove it! Melvin keeps a camera outside his door, right? That camera can show that I never left the living room, the whole day.");
        dialogueMap.put(210, "Detective: Oh yeah, and how do I get through to Melvin? He doesn’t answer his door and doesn’t seem to be talking to anyone here by the sounds of it.");
        dialogueMap.put(211, "Davey: There's a secret door knock Melvin has to know you're cool, and then you can enter the room. I know the knock.");
        dialogueMap.put(212, "Detective: Great! What’s the knock?");
        dialogueMap.put(213, "Davey: Well, like I can tell you it. But first, I need some, uh, money. For, uh, groceries…");
        dialogueMap.put(214, "Detective: Listen here, waster! You’re lucky I’m morally flexible that I’ll go through with this, but I better get that video tape at the end of it!"); // X/Y difference
        dialogueMap.put(215, "Davey: Haaa, cool. Wait, what did I just say? …");
        dialogueMap.put(216, "END");

        /* Fourth interaction dialogue (After giving money) */
        dialogueMap.put(301, "Davey: Right on bro, that’s chill. Here’s the secret knock! You’ll see that the video totally like exonerates me bro.");
        dialogueMap.put(302, "Davey: You'll need a flashlight though, man his room is dark!");
        dialogueMap.put(303, "Davey: Oh my flashlight… that must be in my room. It’s pretty messy though… someone should clean it…");
        dialogueMap.put(304, "END");

        /* Fifth/Final interaction dialogue (After getting flashlight) */
        dialogueMap.put(401, "Davey: I told you I didn’t do it. I don’t think I can really help you further bro. Cough cough cough…");
        dialogueMap.put(402, "END");
    }

    /**
     * Initialises the dialogue for Kyle
     */
    private void kyle() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Kyle: Yo man, I heard the beer got stolen. That is sooo lame! …");
        dialogueMap.put(2, "Detective: Yes indeed. Do you have any idea where it is?");
        dialogueMap.put(3, "Kyle: No idea man. When my room is so messy I can't think straight. I wish someone can make all this mess disappear.. ");
        dialogueMap.put(4, "END");

        /* Second interaction dialogue (After using cleaning supplies) */
        dialogueMap.put(101, "Kyle: Yooo thanks for cleaning up my mess man!");
        dialogueMap.put(102, "Detective: You're welcome. Now can you help me find the beer?");
        dialogueMap.put(103, "Kyle: Ah I'm sorry but I'll be hitting the gym soon, gotta get those gains!");
        dialogueMap.put(104, "END");
    }

    /**
     * Initialises the good cop dialogue for Alex
     */
    private void alex1() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Alex: Thanks for the coffee! Sorry! Can’t talk right now, too much studying to do!!!");
        dialogueMap.put(2, "(It appears she has a computer. If I find some digital footage I might be able to see it here...)"); //
        dialogueMap.put(3, "END");

        /* Second interaction dialogue (after watching video on computer */
        dialogueMap.put(101, "Alex: Thanks for the coffee! Sorry! Can’t talk right now, too much studying to do!!!");
        dialogueMap.put(102, "Detective: I don’t mean to interrupt, but how do you explain taking the crate out of the fridge? I’ve got video evidence."); // X/Y difference
        dialogueMap.put(103, "Alex: Wait! Oh God, It’s not what it seems, I swear.");
        dialogueMap.put(104, "Detective: Then help me out here. Because Sam says that you have an exam tomorrow, and I would get it if you wanted to protect your sleep patterns."); // X/Y difference
        dialogueMap.put(105, "Alex: Oh Samantha, that b*tch! I’m guessing that she failed to tell you about that fight she had with Stacey earlier, huh?");
        dialogueMap.put(106, "Alex: It’s true that I am upset that there is a planned party for tonight, as if I didn’t exist or that studying wasn’t important!");
        dialogueMap.put(107, "Alex: That darn crate was taking up the whole fridge, so I decided I would just temporarily move it to the storage room. ");
        dialogueMap.put(108, "Alex: But then I asked Kyle for the key, and he said he lost it. So I just left it there in front of the door. ");
        dialogueMap.put(109, "Detective: So how do you explain that the beer is no longer there?");
        dialogueMap.put(110, "Alex: I don’t know! It wasn’t me though! I’ve been studying all day!");
        dialogueMap.put(111, "Alex: Kyle might have put the key for the storage room in his safe!");
        dialogueMap.put(112, "Alex: Go talk to Melvin for the code to the safe, but otherwise, I still have an exam tomorrow!!");
        dialogueMap.put(113, "END");

        /* Third interaction dialogue (after breaking drawer */
        dialogueMap.put(201, "Alex: Wow you broke my drawer! I don't like you anymore.");
        dialogueMap.put(202, "END");

        /* Fourth interaction dialogue (After accessing safe) */
        dialogueMap.put(301, "Alex: Oh god, oh god, what if I don’t get a 10?!");
        dialogueMap.put(302, "END");
    }

    /**
     * Initialises the bad cop dialogue for Alex
     */
    private void alex2() {
        /* First interaction dialogue (Start of game) */
        dialogueMap.put(1, "Alex: Thanks for the coffee! Sorry! Can’t talk right now, too much studying to do!!!");
        dialogueMap.put(2, "END");

        /* Second interaction dialogue (after watching video on computer */
        dialogueMap.put(101, "Alex: Thanks for the coffee! Sorry! Can’t talk right now, too much studying to do!!!");
        dialogueMap.put(102, "Detective:  Listen here Missy! we've got hard evidence of you taking the crate of beer out of the fridge! Where are you hiding it!"); // X/Y difference
        dialogueMap.put(103, "Alex: Wait! Oh God, It’s not what it seems, I swear.");
        dialogueMap.put(104, "Detective: Oh yeah? Because Samantha seems to think you’d have a good motive to not have that party, considering your lil test tomorrow and all."); // X/Y difference
        dialogueMap.put(105, "Detective:  You better get to explaining.");
        dialogueMap.put(106, "Alex: Oh Samantha, that b*tch! I’m guessing that she failed to tell you about that fight she had with Stacey earlier, huh?");
        dialogueMap.put(107, "Alex: It’s true that I am upset that there is a planned party for tonight, as if I didn’t exist or that studying wasn’t important!");
        dialogueMap.put(108, "Alex: That darn crate was taking up the whole fridge, so I decided I would just temporarily move it to the storage room. ");
        dialogueMap.put(109, "Alex: But then I asked Kyle for the key, and he said he lost it. So I just left it there in front of the door. ");
        dialogueMap.put(110, "Detective: So how do you explain that the beer is no longer there?");
        dialogueMap.put(111, "Alex: I don’t know! It wasn’t me though! I’ve been studying all day!");
        dialogueMap.put(112, "Alex: Kyle might have put the key for the storage room in his safe!");
        dialogueMap.put(113, "Alex: Go talk to Melvin for the code to the safe, but otherwise, I still have an exam tomorrow!!");
        dialogueMap.put(114, "END");

        /* Third interaction dialogue (after breaking desk */
        dialogueMap.put(201, "Alex: Wow you broke my desk! I don't like you anymore.");
        dialogueMap.put(202, "END");

        /* Fourth interaction dialogue (After accessing safe) */
        dialogueMap.put(301, "Alex: Oh god, oh god, what if I don’t get a 10?!");
        dialogueMap.put(302, "END");
    }

    /**
     * Initialises the good cop dialogue for Melvin
     */
    private void melvin1() {
        /* First interaction dialogue (Start of game/ black room) */
        dialogueMap.put(1, "Melvin: Can I help you?");
        dialogueMap.put(2, "Detective: Hi, I’m a detective. I’m here to find out who stole the crate of beer.");
        dialogueMap.put(3, "Melvin: I usually don’t talk with Cops, let alone help them.");
        dialogueMap.put(4, "Detective: I’m just here for a video tape that Davey says will prove him not guilty. Do you have it somewhere?");
        dialogueMap.put(5, "Melvin: It’s somewhere around here. Find it yourself.");
        dialogueMap.put(6, "Detective: It’s pitch black! Can you turn on the lights?");
        dialogueMap.put(7, "Melvin: I like the dark. You’ll have to use a flashlight. Davey usually has one.");
        dialogueMap.put(8, "END");

        /* Second interaction dialogue (After finding flashlight) */
        dialogueMap.put(101, "Melvin: Two things. First, I usually don’t talk to police, so keep it short. And second, don’t turn on the lights.");
        dialogueMap.put(102, "END");

        /* Third interaction dialogue (After watching video tape on computer) */
        dialogueMap.put(201, "Detective: I heard that you know the code for Kyle’s safe, somehow.");
        dialogueMap.put(202, "Melvin: Maybe. Maybe not. Like I said, I have my ways.");
        dialogueMap.put(203, "Detective: Listen man, can you help me out? I need that code to solve the crime.");// X/Y difference
        dialogueMap.put(204, "Melvin: Let’s say I have that code. What can you do for me?");
        dialogueMap.put(205, "Detective: What do you need, good sir.");// X/Y difference
        dialogueMap.put(206, "Melvin: I need a new computer mouse. Mines broken. I have very important stuff to do, and this trackpad isn’t great for my dexterity.");
        dialogueMap.put(207, "Melvin: Get me that mouse, and the code is yours.");
        dialogueMap.put(208, "Melvin: Samantha might have one in her drawer, but you'll have to force it open.");
        dialogueMap.put(209, "END");

        /* Fourth interaction dialogue (After getting computer mouse) */
        dialogueMap.put(301, "Detective: Here’s that computer mouse for you.");// X/Y difference
        dialogueMap.put(302, "Melvin: Thanks for the help. The code is 420 – what else would you expect from a safe in the room of those two?");
        dialogueMap.put(303, "END");

        /* Fourth interaction dialogue (After accessing safe) */
        dialogueMap.put(401, "Melvin: Thanks for the help. I’ve got computer stuff to get back to now.");
        dialogueMap.put(402, "END");
    }

    /**
     * Initialises the bad cop dialogue for Melvin
     */
    private void melvin2() {
        /* First interaction dialogue (Start of game/ black room) */
        dialogueMap.put(1, "Melvin: Can I help you?");
        dialogueMap.put(2, "Detective: Hi, I’m a detective. I’m here to find out who stole the crate of beer.");
        dialogueMap.put(3, "Melvin: I usually don’t talk with Cops, let alone help them.");
        dialogueMap.put(4, "Detective: I’m just here for a video tape that Davey says will prove him not guilty. Do you have it somewhere?");
        dialogueMap.put(5, "Melvin: It’s somewhere around here. Find it yourself.");
        dialogueMap.put(6, "Detective: It’s pitch black! Can you turn on the lights?");
        dialogueMap.put(7, "Melvin: I like the dark. You’ll have to use a flashlight. Davey usually has one.");
        dialogueMap.put(8, "END");

        /* Second interaction dialogue (After finding flashlight) */
        dialogueMap.put(101, "Melvin: Two things. First, I usually don’t talk to police, so keep it short. And second, don’t turn on the lights.");
        dialogueMap.put(102, "END");

        /* Third interaction dialogue (After watching video tape on computer) */
        dialogueMap.put(201, "Detective: I heard that you know the code for Kyle’s safe, somehow.");
        dialogueMap.put(202, "Melvin: Maybe. Maybe not. Like I said, I have my ways.");
        dialogueMap.put(203, "Detective: I need that code ASAP, hand it over you nerd!");// X/Y difference
        dialogueMap.put(204, "Melvin: Let’s say I have that code. What can you do for me?");
        dialogueMap.put(205, "Detective: I’m past helping you snobs out. I’ll find another way, and you won’t like it!");//X/Y difference
        dialogueMap.put(206, "Detective: (If I cut the internet he won't be able to game anymore, then he will help me!");
        dialogueMap.put(207, "Detective: (I'll need to find scissors and a screwdriver to screw with the panel in the kitchen.");
        dialogueMap.put(208, "Detective: (The study nerd probably has scissors in her drawer, I'll just have to break it open.");
        dialogueMap.put(209, "END");

        /* Fourth interaction dialogue (After getting Scissors + screwdriver + interacting with electrical panel) */
        dialogueMap.put(301, "Detective: Listen buddy, I just cut all the wires for your damn computer project you got going on here. It’ll get a lot worse before it gets better.");// X/Y difference
        dialogueMap.put(302, "Melvin: This is why I don’t trust cops. Twisted pigs. Fine, the code is 420 – what else would you expect from a safe in the room of those two?");
        dialogueMap.put(303, "END");

        /* Fourth interaction dialogue (After accessing safe) */
        dialogueMap.put(401, "Melvin: You'll regret how you treated me today. I swear it…");
        dialogueMap.put(402, "END");
    }

    /*
     * @return the dialogue map
     */
    public HashMap<Integer, String> getDialogueMap() {
        return dialogueMap;
    }

    /**
     * Gives a String in the dialogue map
     * @param n is the value for the key
     * @return the String corresponding to that key, or null if there is no String corresponding to the key
     */
    public String getDialogue(int n){
        if (dialogueMap.get(n) != null) {
            return dialogueMap.get(n);
        } else {
            return null;
        }
    }

    /**
     * @return the current key of the dialogue
     */
    public Integer getCurrentKey() {
        return currentKey;
    }
}
