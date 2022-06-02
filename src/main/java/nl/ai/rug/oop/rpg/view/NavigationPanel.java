package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    private final JButton btn = new JButton("<"); // todo: design. change max size(?)
    public NavigationPanel() {
        setLayout(new BorderLayout(0, 0));
        add(btn, BorderLayout.CENTER);
    }
}
