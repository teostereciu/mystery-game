package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.swing.*;
import java.awt.*;

public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("Text text text");
    private MysteryGame game;
    public DialoguePanel(MysteryGame game) {
        this.game = game;
        setOpaque(true);
        setBackground(Color.black);
        jlbl.setForeground(Color.white);
        add(jlbl);
    }
    public void update() {
        //String txt = game.getRoom(game.getCurrentRoom()).getNPC().getDialogue().getDialogueMap().get(game.getRoom(game.getCurrentRoom()).getNPC().getDialogue().getCurrentKey());
        String dialogueLine = game.getRoom(game.getCurrentRoom()).getNPC().getNPCDialogue().getDialogue(game.getLineCounter());
        jlbl.setText(dialogueLine);
    }
    public void clear() {
        jlbl.setText("");
    }
}
