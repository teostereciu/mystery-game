package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("Text text text");
    public DialoguePanel() {
        this.setOpaque(true);
        this.setBackground(new Color(109, 172, 209));
        jlbl.setForeground(Color.white);
        add(jlbl);
    }
    public void update(String txt) {
        jlbl.setText(txt);
    }
    public void clear() {
        jlbl.setText("");
    }
}
