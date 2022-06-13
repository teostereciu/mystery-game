package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.RoomChooser;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    protected JButton navigateButton = new JButton("<"); // todo: design. change max size(?);
    private MysteryGame game;
    private GameView frame;
    public NavigationPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setLayout(new BorderLayout(0, 0));
        navigateButton.setOpaque(true);
        navigateButton.setBorderPainted(true);
        navigateButton.setBackground(Color.black);
        navigateButton.setPreferredSize((new Dimension(70,10)));
        navigateButton.setEnabled(false);
        navigateButton.addActionListener(new RoomChooser(game, 0, frame));
        add(navigateButton, BorderLayout.CENTER);
    }
    public void enableNavigateButton(Boolean bool) {
        navigateButton.setEnabled(bool);
    }
}
