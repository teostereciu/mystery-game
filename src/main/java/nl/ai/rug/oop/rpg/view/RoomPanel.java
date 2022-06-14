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
 * author: teo stereciu
 */
public class RoomPanel extends JLayeredPane {
    public final int ROOM_WIDTH = 800;
    public final int ROOM_HEIGHT = 500;
    private JLabel roomBackgroundLabel = new JLabel();;
    private ForegroundPanel foregroundPanel;
    private final MysteryGame game;
    private final GameView frame;

    public RoomPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setPreferredSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT));
        displayStartWindow();
    }

    private void displayStartWindow() {
        roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        try {
            Image startImage = ImageIO.read(new File("src/main/resources/detective-choice.png"));
            roomBackgroundLabel.setIcon(new ImageIcon(startImage));
        } catch(IOException e) {
            System.out.println("src/main/resources/detective-choice.png not found.");
            throw new RuntimeException();
        }
        add(roomBackgroundLabel, (Integer) 0);

        foregroundPanel = new ForegroundPanel(ROOM_WIDTH, ROOM_HEIGHT);
        HashMap<String,Integer> coords = new HashMap<>();
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

    public void init() {
        removeAll();
        //roomBackgroundLabel.setBounds(0, 0, ROOM_WIDTH, ROOM_HEIGHT);
        set();
        add(roomBackgroundLabel, (Integer) 0);
        add(foregroundPanel, (Integer) 1);
    }

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
}
