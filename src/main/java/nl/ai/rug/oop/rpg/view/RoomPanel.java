package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.DetectiveChooser;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * A view class for the background panel of the game. It extends JLayeredPane, so foreground layers can be added.
 * @author: teostereciu
 */
public class RoomPanel extends JLayeredPane {

    private final JLabel roomBackgroundLabel = new JLabel();;
    private ForegroundPanel foregroundPanel;
    private final MysteryGame game;
    private final GameView frame;

    /**
     * Constructor for room panel.
     * @param game
     * @param frame
     */
    public RoomPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setPreferredSize(new Dimension(frame.ROOM_WIDTH, frame.ROOM_HEIGHT));
        displayStartWindow();
    }

    /**
     * Displays starting window.
     */
    private void displayStartWindow() {
        roomBackgroundLabel.setBounds(0, 0, frame.ROOM_WIDTH, frame.ROOM_HEIGHT);
        try {
            Image startImage = ImageIO.read(new File("src/main/resources/detective-choice.png"));
            roomBackgroundLabel.setIcon(new ImageIcon(startImage));
        } catch(IOException e) {
            System.out.println("src/main/resources/detective-choice.png not found.");
            throw new RuntimeException();
        }
        add(roomBackgroundLabel, (Integer) 0);

        foregroundPanel = new ForegroundPanel(game, frame);
        HashMap<String, Integer> coords = new HashMap<>();
        coords.put("x", 190);
        coords.put("y", 60);
        JButton goodCopButton = foregroundPanel.newButton("", coords, 180, 160);
        goodCopButton.addActionListener(new DetectiveChooser(game, frame, 1));
        foregroundPanel.add(goodCopButton);

        coords.replace("x", 400);
        JButton badCopButton = foregroundPanel.newButton("", coords, 180, 160);
        badCopButton.addActionListener(new DetectiveChooser(game, frame, 0));
        foregroundPanel.add(badCopButton);
        add(foregroundPanel, (Integer) 1);
    }

    /**
     * Closes view up on item.
     * @param name
     */
    public void closeUpOnItem(String name) {
        try {
            roomBackgroundLabel.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/" + name + "-closeup.png"))));
        } catch (IOException e) {
            System.out.println("src/main/resources/" + name + "-closeup.png not found.");
            throw new RuntimeException(e);
        }
        foregroundPanel.removeAll();
    }

    /**
     * Initializes the room panel.
     */
    public void init() {
        removeAll();
        set();
        add(roomBackgroundLabel, (Integer) 0);
        add(foregroundPanel, (Integer) 1);
    }

    /**
     * Sets the room panel following the model.
     */
    public void set() {
        try {
            roomBackgroundLabel.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/rooms/room" + game.getCurrentRoomNum() + ".png"))));
        } catch (IOException e) {
            System.out.println("src/main/resources/rooms/room" + game.getCurrentRoomNum() + ".png not found.");
            throw new RuntimeException(e);
        }
        foregroundPanel.removeAll();
        foregroundPanel.set(game, frame);
    }

    /**
     * Updates to ending view.
     */
    public void updateToEnding() {
        removeAll();
        try {
            roomBackgroundLabel.setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/ending.png"))));
        } catch (IOException e) {
            System.out.println("src/main/resources/ending.png not found.");
            throw new RuntimeException(e);
        }
        add(roomBackgroundLabel, (Integer)0);
    }
}
