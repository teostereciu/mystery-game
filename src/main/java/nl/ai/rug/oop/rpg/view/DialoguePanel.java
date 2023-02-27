package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.Dialoguer;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.model.NPC;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * A JPanel class for the dialogue.
 * @author teostereciu
 */
public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("");
    private GameView frame;
    private MysteryGame game;
    private JButton nextButton;

    /**
     * Constructor for the dialogue panel class.
     * @param game
     * @param frame
     */
    public DialoguePanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setOpaque(true);
        setBackground(Color.black);
        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black, 5));
        jlbl.setForeground(Color.white);
        jlbl.setPreferredSize(new Dimension(600, 60));
        add(jlbl, BorderLayout.CENTER);
        nextButton = new JButton(">");
        nextButton.setPreferredSize(new Dimension(40,40));
        nextButton.addActionListener(new Dialoguer(game, frame));
        add(nextButton, BorderLayout.EAST);
        clear();
    }

    /**
     * Updates the dialogue panel.
     */
    public void update() {
        clear();
        jlbl.setForeground(Color.white);
        NPC npc = game.getRoom(game.getCurrentRoomNum()).getNPC();
        String dialogueLine = npc.getNPCDialogue().getDialogueMap().get(npc.getDialogueCounter() * game.MAX_DIALOGUE_OPTIONS + npc.getNPCDialogue().getCurrentKey());
        jlbl.setText(dialogueLine);
        jlbl.setVisible(true);
        nextButton.setEnabled(true);
        nextButton.setVisible(true);
        if (Objects.equals(dialogueLine, "END")) {
            if (game.getRoom(0).getNPC().getNPCDialogue().getCurrentKey() == 12) {
                frame.displayEnding();
            }
            clear();
        }
        if (jlbl == null) {
            clear();
        }
    }

    /**
     * Used to clear the dialogue panel when there is no ongoing dialogue.
     */
    public void clear() {
        jlbl.setText("");
        nextButton.setEnabled(false);
        nextButton.setVisible(false);
    }
}
