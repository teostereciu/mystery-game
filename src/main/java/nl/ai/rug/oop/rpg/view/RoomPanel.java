package nl.ai.rug.oop.rpg.view;

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
    private MysteryGame game;
    private JLabel roomBackgroundLabel;
    private ForegroundPanel foregroundPanel;
    public RoomPanel() {
        setPreferredSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT));
        displayStartWindow();
    }
    private void displayStartWindow() {
        JLabel startLabel = new JLabel();
        startLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        try {
            ImageIcon startImageIcon = new ImageIcon(ImageIO.read(new File("src/main/resources/detective-choice.png")));
            startLabel.setIcon(startImageIcon);
        } catch(IOException e) {
            throw new RuntimeException();
        }
        add(startLabel, POPUP_LAYER);
    }
    public void init(MysteryGame game) {
        this.game = game;
        removeAll();
        roomBackgroundLabel = new JLabel();
        roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        foregroundPanel = new ForegroundPanel(ROOM_WIDTH, ROOM_HEIGHT);
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
