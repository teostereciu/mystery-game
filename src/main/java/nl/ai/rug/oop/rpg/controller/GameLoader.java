package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for loading a saved game state.
 * @author veghcsanad
 */
public class GameLoader implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;

    /**
     * Constructor of the GameLoader class.
     * @param game
     * @param frame
     */
    public GameLoader(MysteryGame game, GameView frame){
        this.modelGame = game;
        this.viewFrame = frame;
    }

    /**
     * Called when "Load game" button in the menu is clicked.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int outcome = viewFrame.displayGameOptions(1);
        if (outcome == 1) {
            modelGame.loadGame();
        }
    }
}