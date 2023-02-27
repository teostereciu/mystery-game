package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for advancing the dialogue
 */

public class Dialoguer implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;

    /**
     * Constructor for the Dialoguer class.
     * @param game
     * @param frame
     */
    public Dialoguer(MysteryGame game, GameView frame){
        this.modelGame = game;
        this.viewFrame = frame;
    }
    /**
     * Called when dialogue is advanced (clicked on NPC)
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.updateDialogue();
        if (modelGame.getRoom(0).getNPC().getNPCDialogue().getCurrentKey() != 412) {

            viewFrame.updateDialoguePanel();
        } else {
            viewFrame.displayEnding();
        }
    }
}
