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
import java.util.ArrayList;
import java.util.HashMap;

public class ForegroundPanel extends JPanel {

    private MysteryGame game;
    private GameView frame;

    public ForegroundPanel(int width, int height) {
        setLayout(null);
        setBounds(0, 0, width, height);
        setOpaque(false);
    }

    public void set(MysteryGame game, GameView frame) {
        removeAll();
        if (this.game == null) {
            this.game = game;
        }
        if (this.frame == null) {
            this.frame = frame;
        }
        if (game.getCurrentRoomNum() == 0) {
            addDoorButtons(); // todo consider having the buttons on a sublayer
        }
        for (Item currentItem : game.getRoom(game.getCurrentRoomNum()).getRoomItems()) {
            try {
                JButton itemButton = newButton("items/" + currentItem.getItemName(), currentItem.getCoords());
                itemButton.addActionListener(new ItemChooser(game, currentItem, frame));
            } catch (IOException e) {
                System.out.println(currentItem.getItemName() + ".png not found.");
                throw new RuntimeException(e);
            }
        }
        try {
            JButton npcButton = newButton("npcs/" + game.getRoom(game.getCurrentRoomNum()).getNPC().getName(), game.getRoom(game.getCurrentRoomNum()).getNPC().getCoords());
            npcButton.addActionListener(new Dialoguer(game, frame));
        } catch (IOException e) {
            System.out.println(game.getRoom(game.getCurrentRoomNum()).getNPC().getName() + ".png not found.");
            throw new RuntimeException(e);
        }
    }

    private JButton newButton(String name, HashMap<String,Integer> coords) throws IOException { // todo: 4csanad stuff here
        Image img = ImageIO.read(new File("src/main/resources/" + name + ".png"));
        JButton btn = new JButton(new ImageIcon(img));
        System.out.println(name);
        btn.setBounds(coords.get("x"), coords.get("y"), img.getWidth(null), img.getHeight(null));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        add(btn);
        return btn;
    }

    private void addDoorButtons() { // todo add some labels maybe
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 6; i ++) {
            btns.add(new JButton());
            btns.get(i).setOpaque(false);
            btns.get(i).setContentAreaFilled(false);
            btns.get(i).setBorderPainted(false);
            btns.get(i).addActionListener(new RoomChooser(game, i + 1));
            switch (i) {
                case 0 -> btns.get(i).setBounds(50, 180, 90, 190); // note: this leads to room1 (common area)
                case 1 -> btns.get(i).setBounds(170, 180, 90, 190);
                case 2 -> btns.get(i).setBounds(290, 180, 90, 190);
                case 3 -> btns.get(i).setBounds(410, 180, 90, 190);
                case 4 -> btns.get(i).setBounds(530, 180, 90, 190);
                case 5 -> btns.get(i).setBounds(650, 180, 90, 190);
            }
            add(btns.get(i));
        }
    }
}
