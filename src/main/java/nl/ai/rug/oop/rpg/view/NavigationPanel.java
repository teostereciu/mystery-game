package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.RoomChooser;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel for room navigation. Allows the user to return to the hallway.
 * @author teostereciu
 */
public class NavigationPanel extends JPanel {
    private final JButton navigateButton = new JButton("<"); // todo: design.
    private MysteryGame game;
    private GameView frame;

    /**
     * Cosntructor for the navigation panel.
     * @param game
     * @param frame
     */
    public NavigationPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setLayout(new BorderLayout(0, 0));
        navigateButton.setOpaque(true);
        navigateButton.setBorderPainted(true);
        navigateButton.setBackground(Color.black);
        navigateButton.setForeground(Color.white);
        navigateButton.setEnabled(false);
        navigateButton.addActionListener(new RoomChooser(game, 0, frame));
        add(navigateButton, BorderLayout.CENTER);
    }

    /**
     * Enables and disables the navigation button.
     * @param bool
     */
    public void enableNavigateButton(Boolean bool) {
        navigateButton.setEnabled(bool);
    }

    /**
     * Changes the destinationof the navigation button.
     * @param currentRoomNum
     */
    public void changeDestination(int currentRoomNum) {
        navigateButton.removeActionListener(navigateButton.getActionListeners()[0]);
        navigateButton.addActionListener(new RoomChooser(game, currentRoomNum, frame));
    }
}
