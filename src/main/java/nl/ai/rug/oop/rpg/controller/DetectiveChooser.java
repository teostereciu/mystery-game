package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetectiveChooser implements ActionListener {
    MysteryGame modelGame;
    GameView viewFrame;
    int isGood;
    public DetectiveChooser(MysteryGame game, GameView frame, int isGood) {
        viewFrame = frame;
        modelGame = game;
        this.isGood = isGood;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.setDetective(isGood);
        viewFrame.setPanels();
        viewFrame.displayDetectiveWarnings(10 + isGood);
    }
}
