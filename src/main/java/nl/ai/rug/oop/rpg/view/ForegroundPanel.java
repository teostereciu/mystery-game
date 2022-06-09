package nl.ai.rug.oop.rpg.view;

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
    public void set(int roomIdx) throws IOException {
        setLayout(null);
        setBounds(0,0,1067,600);
        setOpaque(false);
        btnsDict.clear();
        switch(roomIdx) {
            case 0:
                addDoorBtns();
                btns.add(newBtn("items/euro", 0.2, 500, 100));
                btns.add(newBtn("npcs/sam", 0.5, 470, 260));
                btns.add(newBtn("items/cleaning-supplies", 0.15, 845, 345));
                break;
            case 1:
                btns.add(newBtn("npcs/davey", 1.5, 130, 210));
                btns.add(newBtn("items/electric-panel", 0.58, 705, 165));
                break;
            case 2:
                btns.add(newBtn("npcs/sam", 1.3, 800, 280));
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
        img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
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
            switch (i) {
                case 0 -> btns.get(i).setBounds(40, 270, 110, 210); // note: this leads to room1 (common area)
                case 1 -> btns.get(i).setBounds(220, 250, 100, 200);
                case 2 -> btns.get(i).setBounds(390, 250, 100, 200);
                case 3 -> btns.get(i).setBounds(560, 250, 100, 200);
                case 4 -> btns.get(i).setBounds(750, 250, 100, 200);
                case 5 -> btns.get(i).setBounds(920, 270, 110, 210);
            }
            add(btns.get(i));
        }
    }
}
