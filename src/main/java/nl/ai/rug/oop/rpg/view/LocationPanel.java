package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

public class LocationPanel extends JPanel {
    private JLabel roomLbl = new JLabel("Main Room");
    public LocationPanel() {
        this.setOpaque(true);
        this.setBackground(Color.white);
        add(roomLbl);
    }
    public void update(int roomIdx) { // note: if NPC's change, update this
        String txt;
        switch (roomIdx) {
            case 1 -> txt = "Stacey's Room";
            case 2 -> txt = "Samantha's Room";
            case 3 -> txt = "Davey's Room";
            case 4 -> txt = "Marvin's Room";
            case 5 -> txt = "Alex's Room";
            default -> txt = "Main Room";
        }
        roomLbl.setText(txt);
    }
}
