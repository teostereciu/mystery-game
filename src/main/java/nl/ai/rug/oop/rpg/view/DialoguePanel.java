package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.swing.*;
import java.awt.*;

public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("Text text text");
    private GameView frame;
    private MysteryGame game;
    public DialoguePanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setOpaque(true);
        setBackground(Color.black);
        //setSize(700, 100);
        jlbl.setForeground(Color.white);
        add(jlbl);
    }
    public void update() {
        //Note from daniel: The next line works, however not completely yet.
        //Also: Lines need to be shorter. I can make that work
        String dialogueLine = game.getRoom(game.getCurrentRoom()).getNPC().getNPCDialogue().getDialogueMap().get(game.getRoom(game.getCurrentRoom()).getNPC().getDialogueCounter() * game.getMAX_DIALOGUE_OPTIONS() + game.getRoom(game.getCurrentRoom()).getNPC().getNPCDialogue().getCurrentKey());
        //String dialogueLine = game.getRoom(game.getCurrentRoom()).getNPC().getNPCDialogue().getDialogue(game.getLineCounter());
        jlbl.setText(dialogueLine);
    }
    public void clear() {
        jlbl.setText("");
    }
}
