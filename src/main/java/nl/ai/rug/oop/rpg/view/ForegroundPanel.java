package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.RoomChooser;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class ForegroundPanel extends JPanel {

    Hashtable<Integer, JButton> btnsDict = new Hashtable<>();
    //ArrayList<Item> gameItems = new ArrayList<>(); // todo: have this in the model
    /*public ForegroundPanel(ArrayList<Item> gameItems) throws IOException {
        setLayout(null);
        setBounds(0,0,1067,600);
        setOpaque(false);
        addDoorBtns();
        btnsDict.put((Integer)1, newBtn(gameItems.get(1))); // also game.getItems.get(1).getXCoord() and .getYCoord()

    }*/

    //public void set(int roomIdx) {

    //}

    private ArrayList<JButton> btns = new ArrayList<>();
    private MysteryGame game;
    public ForegroundPanel(MysteryGame game) {
        this.game = game;
    }
    public void set(int roomIdx) throws IOException {
        setLayout(null);
        setBounds(0,0,800,500);
        setOpaque(false);
        btnsDict.clear();
        if (roomIdx == 0) {
            addDoorBtns();
        }
        SwingUtilities.updateComponentTreeUI(this);
        switch(roomIdx) {
            case 0:
                addDoorBtns();
                btns.add(newBtn("items/pxeuro", 0.2, 380, 50));
                btns.add(newBtn("npcs/pxstacey", 0.5, 450, 200));
                btns.add(newBtn("items/pxcleaning-supplies", 0.15, 70, 270));
                break;
            case 1:
                btns.add(newBtn("npcs/pxdavey", 1.5, 70, 100));
                btns.add(newBtn("npcs/pxsam", 1.5, 190, 100));
                btns.add(newBtn("npcs/pxalex", 1.5, 310, 100));
                btns.add(newBtn("npcs/pxkyle", 1.5, 430, 100));
                btns.add(newBtn("npcs/pxmelvin", 1.5, 550, 100));
                btns.add(newBtn("items/pxelectric-panel", 0.58, 360, 150));
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
    }
    private JButton newBtn(String name, double scale, int x, int y) throws IOException { // todo: 4csanad stuff here
        Image img = ImageIO.read(new File("src/main/resources/" + name + ".png"));
        //img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        JButton btn = new JButton(new ImageIcon(img));
        btn.setBounds(x, y, img.getWidth(null), img.getHeight(null));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        add(btn);
        return btn;
    }

    protected void removeBtn(int id) { // todo: !!!find a way to id the buttons
        remove(btns.get(id));
    }

    private void addDoorBtns() { // todo: 4csanad - functionality for these buttons
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 6; i ++) {
            btns.add(new JButton());
            btns.get(i).setOpaque(false);
            btns.get(i).setContentAreaFilled(false);
            btns.get(i).setBorderPainted(false);
            btns.get(i).addActionListener(new RoomChooser(game, i + 1)); // todo: import game
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
