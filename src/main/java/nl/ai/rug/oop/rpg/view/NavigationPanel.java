package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.RoomChooser;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    protected JButton btn = new JButton("<"); // todo: design. change max size(?); 4csanad - pressing this btn should lead back to room0
    public NavigationPanel() {
        setLayout(new BorderLayout(0, 0));
        btn.setOpaque(true);
        btn.setBorderPainted(true);
        btn.setBackground(Color.black);
        btn.setPreferredSize((new Dimension(70,10)));
        btn.setEnabled(false);
        btn.addActionListener(RoomChooser(game, 0)); // todo: import game
        add(btn, BorderLayout.CENTER);
    }
    public void enableBtn(Boolean bool) {
        btn.setEnabled(bool);
    }
}
