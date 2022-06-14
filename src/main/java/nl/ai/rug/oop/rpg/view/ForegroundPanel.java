package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.Dialoguer;
import nl.ai.rug.oop.rpg.controller.ItemChooser;
import nl.ai.rug.oop.rpg.controller.RoomChooser;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ForegroundPanel extends JPanel {

    private MysteryGame game;
    private GameView frame;

    public ForegroundPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setLayout(null);
        setBounds(0, 0, frame.ROOM_WIDTH, frame.ROOM_HEIGHT);
        setOpaque(false);
    }

    public void set(MysteryGame game, GameView frame) {
        removeAll();
        this.game = game;
        this.frame = frame;

        if (game.getCurrentRoomNum() == 0) {
            addDoors();
        }

        if (game.getCurrentRoomNum() == 5 && !game.getFlashlightIsOn()) {
            makeDark();
            return;
        }

        for (Item currentItem : game.getRoom(game.getCurrentRoomNum()).getRoomItems()) {
            JButton itemButton = newButton("items/" + currentItem.getItemName(), currentItem.getCoords(), 0, 0);
            itemButton.addActionListener(new ItemChooser(game, currentItem, frame));
        }

        if (game.getRoom(game.getCurrentRoomNum()).getNPC() != null) {
            JButton npcButton = newButton("npcs/" + game.getRoom(game.getCurrentRoomNum()).getNPC().getName(), game.getRoom(game.getCurrentRoomNum()).getNPC().getCoords(), 0, 0);
            npcButton.addActionListener(new Dialoguer(game, frame));
        }
    }

    public void addDoors() { // todo add some labels maybe; change artwork
        JButton doorButton = null;
        for(int i = 1; i < game.NUMBER_OF_ROOMS; i ++) {
            HashMap<String,Integer> coords = new HashMap<>();
            coords.put("x", 50 + (i - 1) * 120);
            coords.put("y", 170);
            doorButton = newButton("", coords, 100, 180);
            doorButton.addActionListener(new RoomChooser(game, i, frame));
        }
    }

    public JButton newButton(String name, HashMap<String,Integer> coords, int buttonWidth, int buttonHeight) {
        JButton button = new JButton();

        if (!Objects.equals(name, "")) {
            try {
                Image image = ImageIO.read(new File("src/main/resources/" + name + ".png"));
                button.setIcon(new ImageIcon(image));
                button.setBounds(coords.get("x"), coords.get("y"), image.getWidth(null), image.getHeight(null));
            } catch (IOException e) {
                System.out.println("src/main/resources/" + name + ".png not found.");
                throw new RuntimeException(e);
            }
        } else {
            button.setBounds(coords.get("x"), coords.get("y"), buttonWidth, buttonHeight);
        }

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        add(button);
        return button;
    }

    public void makeDark() {
        JLabel darkLabel = null;
        try {
            darkLabel = new JLabel(new ImageIcon(ImageIO.read(new File("src/main/resources/rooms/darkness.png"))));
            darkLabel.setBounds(0, 0, frame.ROOM_WIDTH, frame.ROOM_HEIGHT);
        } catch (IOException e) {
            System.out.println("src/main/resources/rooms/darkness.png not found.");
            throw new RuntimeException(e);
        }
        add(darkLabel);
    }
}
