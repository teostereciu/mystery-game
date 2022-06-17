package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel for the showing the location.
 * @author teostereciu
 */
public class LocationPanel extends JPanel {
    private final JLabel roomLabel = new JLabel();

    /**
     * Constructor for the location panel.
     */
    public LocationPanel() {
        setOpaque(true);
        setBackground(Color.black);
        roomLabel.setForeground(Color.white);
        roomLabel.setText("Hallway");
        add(roomLabel);
    }

    /**
     * Updates the shown location.
     * @param roomIdx
     */
    public void update(int roomIdx) {
        String text;
        switch (roomIdx) {
            case 1 -> text = "Kitchen";
            case 2 -> text = "Stacey and Samantha's Room";
            case 3 -> text = "Davey and Kyle's Room";
            case 4 -> text = "Alex's Room";
            case 5 -> text = "Melvin's Room";
            case 6 -> text = "Storage Room";
            default -> text = "Hallway";
        }
        roomLabel.setText(text);
    }
}
