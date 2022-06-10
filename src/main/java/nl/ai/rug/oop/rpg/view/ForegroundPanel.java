package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.RoomChooser;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.model.Room;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ForegroundPanel extends JPanel {

    private ArrayList<JButton> itemBtns = new ArrayList<>();
    private MysteryGame game;
    public ForegroundPanel(int width, int height) {
        setLayout(null);
        setBounds(0, 0, width, height);
        setOpaque(false);
    }

    public void set(@NotNull MysteryGame game) {
        removeAll();
        if (this.game == null) {
            this.game = game;
        }
        if (game.getCurrentRoom() == 0) {
            addDoorButtons();
        }
        for (Item currentItem : game.getRoom(game.getCurrentRoom()).getRoomItems()) {
            try {
                newButton("items/" + currentItem.getItemName(), currentItem.getCoords());
            } catch (IOException e) {
                System.out.println(currentItem.getItemName() + ".png not found.");
                throw new RuntimeException(e);
            }
        }
        try {
            newButton("npcs/" + game.getRoom(game.getCurrentRoom()).getNPC().getName(), game.getRoom(game.getCurrentRoom()).getNPC().getCoords());
        } catch (IOException e) {
            System.out.println(game.getRoom(game.getCurrentRoom()).getNPC().getName() + ".png not found.");
            throw new RuntimeException(e);
        }
    }
    /*public ForegroundPanel(@NotNull MysteryGame game, int roomIdx) {
        this.game = game;
        Room room = game.getRoom(roomIdx);
        setLayout(null);
        setBounds(0,0,800,500);
        setOpaque(false);
        if (roomIdx == 0) {
            addDoorBtns();
            for (Item currentItem : room.getRoomItems()) {
                //System.out.println(roomIdx+ ": items - " + currentItem.getItemName());
                try {
                    itemBtns.add(newBtn("items/" + currentItem.getItemName(), currentItem.getCoords())); // id btns by the idx. same idx in model for itms
                } catch (IOException e) {
                    //System.out.println("Item missing" + roomIdx);
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            newBtn("npcs/" + room.getNPC().getName(), room.getNPC().getCoords());
        } catch (IOException e) {
            //System.out.println("NPC missing: " + room.getNPC().getName());
            throw new RuntimeException(e);
        }
    }*/
    /*public void set(int roomIdx) throws IOException {
        setLayout(null);
        setBounds(0,0,800,500);
        setOpaque(false);
        SwingUtilities.updateComponentTreeUI(this);
        switch(roomIdx) {
            case 0:
                addDoorBtns();
                btnsDict.put((Integer)1, newBtn(gameItems.get(1)));
                btns.add(newBtn("items/pxeuro", 0.2, 380, 50));
                btns.add(newBtn("npcs/pxstacey", 0.5, 450, 200));
                btns.add(newBtn("items/pxcleaning-supplies", 0.15, 70, 270));
                break;
            case 1:
                btns.add(newBtn("npcs/pxdavey", 1.5, 70, 100));
                //btns.add(newBtn("npcs/pxsam", 1.5, 190, 100));
                //btns.add(newBtn("npcs/pxalex", 1.5, 310, 100));
                //btns.add(newBtn("npcs/pxkyle", 1.5, 430, 100));
                //btns.add(newBtn("npcs/pxmelvin", 1.5, 550, 100));
                //btns.add(newBtn("items/pxelectric-panel", 0.58, 360, 150));
                break;
            case 2:
                btns.add(newBtn("npcs/sam", 1.3, 250, 200));
                break;
            case 3:
                btns.add(newBtn("npcs/kyle", 1.3, 800, 280));
            case 4:
                btns.add(newBtn("npcs/alex", 1.3, 800, 280));
            case 5:
                btns.add(newBtn("npcs/melvin", 1.3, 800, 280));
            case 6:

        }
    }*/
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

    protected void removeBtn(int id) { // todo: !!!find a way to id the buttons
        remove(itemBtns.get(id));
    }

    private void addDoorButtons() {
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
