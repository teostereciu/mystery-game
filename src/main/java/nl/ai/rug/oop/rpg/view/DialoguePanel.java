package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.Dialoguer;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.model.NPC;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("");
    private GameView frame;
    private MysteryGame game;
    private JButton nextButton;
    public DialoguePanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setOpaque(true);
        setBackground(Color.black);
        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black, 5));
        //setSize(700, 100);
        jlbl.setForeground(Color.white);
        jlbl.setPreferredSize(new Dimension(600, 60));
        add(jlbl, BorderLayout.CENTER);
        nextButton = new JButton(">");
        nextButton.setPreferredSize(new Dimension(40,40));
        //nextButton.setForeground(Color.white);
        nextButton.addActionListener(new Dialoguer(game, frame));
        add(nextButton, BorderLayout.EAST);
        clear();
    }
    public void update() {
        nextButton.setEnabled(true);
        nextButton.setVisible(true);
        jlbl.setForeground(Color.white);
        NPC npc = game.getRoom(game.getCurrentRoomNum()).getNPC();
        String dialogueLine = npc.getNPCDialogue().getDialogueMap().get(npc.getDialogueCounter() * game.MAX_DIALOGUE_OPTIONS + npc.getNPCDialogue().getCurrentKey());
        jlbl.setText(dialogueLine);
        if (Objects.equals(dialogueLine, "END")) {
            clear();
        }
    }
    public void clear() {
        jlbl.setText("");
        nextButton.setEnabled(false);
        nextButton.setVisible(false);
    }
}
