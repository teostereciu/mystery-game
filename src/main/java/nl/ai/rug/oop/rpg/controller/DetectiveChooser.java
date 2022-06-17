package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for choosing the detective.
 * @author veghcsanad
 */

public class DetectiveChooser implements ActionListener {
    MysteryGame modelGame;
    GameView viewFrame;
    int isGood;

    /**
     * Constructor of the DetectiveChooser class.
     * @param game
     * @param frame
     * @param isGood
     */
    public DetectiveChooser(MysteryGame game, GameView frame, int isGood) {
        viewFrame = frame;
        modelGame = game;
        this.isGood = isGood;
    }
    /**
     * Called when a detective is chosen in the beginning.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.setDetective(isGood);
        viewFrame.setPanels();
        viewFrame.displayDetectiveWarnings(10 + isGood);
    }
}
