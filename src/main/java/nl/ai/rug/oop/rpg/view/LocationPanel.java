package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

public class LocationPanel extends JPanel {
    private JLabel roomLbl = new JLabel("Hallway");
    public LocationPanel() {
        setOpaque(true);
        setBackground(Color.black);
        roomLbl.setForeground(Color.white);
        add(roomLbl);
    }
    public void update(int roomIdx) { // todo: 4csanad - use this to update the label
        String txt;
        switch (roomIdx) {
            case 1 -> txt = "Kitchen";
            case 2 -> txt = "Stacey's and Samantha's Room";
            case 3 -> txt = "Davey's and Kyle's Room";
            case 4 -> txt = "Melvin's Room";
            case 5 -> txt = "Alex's Room";
            case 6 -> txt = "Storage Room";
            default -> txt = "Hallway";
        }
        roomLbl.setText(txt);
    }
}
