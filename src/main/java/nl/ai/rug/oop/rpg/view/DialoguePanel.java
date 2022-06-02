package nl.ai.rug.oop.rpg.view;

import javax.swing.*;

public class DialoguePanel extends JPanel { // note: as a possible future feature this could show the npc talking
    private JLabel jlbl = new JLabel("Text text text");
    public DialoguePanel() {
        add(jlbl);
    }
    public void update(String txt) {
        jlbl.setText(txt);
    }
    public void clear() {
        jlbl.setText("");
    }
}
