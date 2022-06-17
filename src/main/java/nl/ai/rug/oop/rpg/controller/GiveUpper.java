package nl.ai.rug.oop.rpg.controller;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A controller class for the giving up on a Crazy Eights game.
 */
public class GiveUpper implements ActionListener {
    /**
     * Allows the program to exis (after confirmation) when the "Give up" button is clicked.
     * @param e the event to be processed
     */
    private GameView viewFrame;
    public GiveUpper(GameView frame) {
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int outcome = viewFrame.displayGameOptions(2);
        if (outcome == 1) {
            System.out.println("Congrats on being a quitter...");
            System.exit(0);
        }
    }
}