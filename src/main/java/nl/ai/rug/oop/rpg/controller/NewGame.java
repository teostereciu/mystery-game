package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame implements ActionListener {
    GameView gameView;

    /**
     * Constructor of the NewGame class.
     * @param gameView
     */
    public NewGame(GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Allows the game to restart (upon confirmation from the user) when the "New game" button is clicked.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        int decision = JOptionPane.showConfirmDialog(null,"Are you sure you want to start a new game? This will end your progress in the current game.\nMake sure to save your changes first!");
        if (decision == 0) {
            gameView.dispose();
            GameView gameView = new GameView();
        }
    }
}