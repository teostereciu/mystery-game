package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.PutBackItem;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private ArrayList<JButton> btnList = new ArrayList<>();
    private MysteryGame game;
    private GameView frame;
    final int SIZE = 5;
    public InventoryPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        GridLayout gridLayout = new GridLayout(SIZE + 1, 1);
        setLayout(gridLayout);
        setOpaque(false);
        JButton btn = newEmptyButton();
        btn.setText("Inventory"); // todo: 4csanad idk - could hide/reveal the item list. or some instructions
        for (int i = 0; i < SIZE; i ++) {
            btnList.add(newEmptyButton()); // todo: 4csanad - discard item
        }
    }
    private JButton newEmptyButton() {
        JButton jButton = new JButton();
        jButton.setOpaque(true);
        jButton.setBorderPainted(true);
        jButton.setBackground(Color.black);
        add(jButton);
        return jButton;
    }
    /*public void addItem(String name, int slot) { // todo: make sure empty slot is being kept track of in model
        Image img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/items" + name + ".png"));
        } catch (IOException e) {
            System.out.println("Image item to be added to inventory could not be found.");
            throw new RuntimeException(e);
        }
        //img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        btnList.get(slot).setIcon(new ImageIcon(img)); //todo: 4csanad - use this when adding an item to the inventory
    }*/
    public void update() {
        int i;
        for (i = 0; i < game.getInventory().getItemsArray().size(); i ++) {
            System.out.println("i");
            if (game.getInventory().getItemsArray().get(i) != null) {
                String name = game.getInventory().getItemsArray().get(i).getItemName();
                try {
                    btnList.get(i).setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/items/" + name + ".png"))));
                    btnList.get(i).addActionListener(new PutBackItem(game, game.getInventory().getItemsArray().get(i), frame));
                    //btnList.get(i).setOpaque(true);
                    //btnList.get(i).setContentAreaFilled(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (; i < 5; i ++) {
            btnList.get(i).setIcon(null);
        }
    }
    public void removeItem(int slot) {
        btnList.get(slot).setIcon(new ImageIcon());
    } // todo: 4csanad - discard item with this
}
