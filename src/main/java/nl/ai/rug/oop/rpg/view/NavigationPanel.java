package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    protected JButton btn = new JButton(">"); // todo: design. change max size(?)
    public NavigationPanel() {
        setLayout(new BorderLayout(0, 0));
        btn.setOpaque(true);
        btn.setBorderPainted(true);
        btn.setBackground(new Color(235,190,130));
        btn.setPreferredSize((new Dimension(70,10)));
        add(btn, BorderLayout.CENTER);
    }
    protected void changeText() {
        btn.setText("<");
    }
}
