package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.DetectiveChooser;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A view class for the background panel of the game. It extends JLayeredPane, so foreground layers can be added.
 * author: teo stereciu
 */
public class RoomPanel extends JLayeredPane {
    private final int ROOM_WIDTH = 800;
    private final int ROOM_HEIGHT = 500;
    //private int detectiveChoice;
    private final MysteryGame game;
    private JLabel roomBackgroundLabel;
    private ForegroundPanel foregroundPanel;
    private GameView frame;
    public RoomPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setPreferredSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT));
        displayStartWindow();
    }
    private void displayStartWindow() {
        roomBackgroundLabel = new JLabel();
        roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        try {
            ImageIcon startImageIcon = new ImageIcon(ImageIO.read(new File("src/main/resources/detective-choice.png")));
            roomBackgroundLabel.setIcon(startImageIcon);
        } catch(IOException e) {
            throw new RuntimeException();
        }
        add(roomBackgroundLabel, (Integer) 0);
        foregroundPanel = new ForegroundPanel(ROOM_WIDTH, ROOM_HEIGHT);
        JButton goodCopButton = new JButton();
        JButton badCopButton = new JButton(); // todo shorthen this bit by using the foreground
        goodCopButton.setBounds(190, 60, 180, 160);
        goodCopButton.setOpaque(false);
        goodCopButton.setContentAreaFilled(false);
        goodCopButton.setBorderPainted(false);
        goodCopButton.addActionListener(new DetectiveChooser(game, frame, 0));
        badCopButton.setBounds(400, 60, 180, 160);
        badCopButton.setOpaque(false);
        badCopButton.setContentAreaFilled(false);
        badCopButton.setBorderPainted(false);
        badCopButton.addActionListener(new DetectiveChooser(game, frame, 1));
        foregroundPanel.add(goodCopButton);
        foregroundPanel.add(badCopButton);
        add(foregroundPanel, (Integer) 1);
    }
    public void init() {
        removeAll();
        roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        set();
        add(roomBackgroundLabel, (Integer) 0);
        add(foregroundPanel, (Integer) 1);
    }
    public void set() {
        try {
            roomBackgroundLabel.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/rooms/room" + game.getCurrentRoom() + ".png"))));
        } catch (IOException e) {
            System.out.println("room" + game.getCurrentRoom() + ".png not found.");
            throw new RuntimeException(e);
        }
        foregroundPanel.removeAll();
        foregroundPanel.set(game);
    }
    /*public void set(int prevIdx, int destIdx) {
        lbl.setIcon(bgImageIcons.get(destIdx));
        foregroundPanelArrayList.get(prevIdx).setVisible(false);
        foregroundPanelArrayList.get(prevIdx).setEnabled(false);
        foregroundPanelArrayList.get(destIdx).setVisible(true);
        foregroundPanelArrayList.get(destIdx).setEnabled(true);
        SwingUtilities.updateComponentTreeUI(this);
    }*/
}
