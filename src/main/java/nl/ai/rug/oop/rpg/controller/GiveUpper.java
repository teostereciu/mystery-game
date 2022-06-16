package nl.ai.rug.oop.rpg.controller;
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
    @Override
    public void actionPerformed(ActionEvent e) {
        int decision = JOptionPane.showConfirmDialog(null,"Are you sure you want to give up?");
        if (decision == 0) {
            System.out.println("Congrats on being a quitter...");
            System.exit(0);
        }
    }
}