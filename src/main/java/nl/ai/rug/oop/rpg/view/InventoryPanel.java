package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.PutBackItem;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private ArrayList<JButton> inventoryButtonsList = new ArrayList<>();
    private final MysteryGame game;
    private final GameView frame;
    final int SIZE = 5; // todo replace with cont from model
    public InventoryPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        GridLayout gridLayout = new GridLayout(SIZE + 1, 1);
        setLayout(gridLayout);
        setOpaque(false);
        JButton btn = newEmptyButton();
        btn.setText("Inventory"); // todo: 4csanad idk - could hide/reveal the item list. or some instructions
        for (int i = 0; i < SIZE; i ++) {
            inventoryButtonsList.add(newEmptyButton());
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

    public void update() {
        int i;
        for (i = 0; i < game.getInventory().getItemsArray().size(); i ++) {
            System.out.println("i");
            if (game.getInventory().getItemsArray().get(i) != null) {
                String name = game.getInventory().getItemsArray().get(i).getItemName();
                try {
                    inventoryButtonsList.get(i).setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/items/" + name + ".png"))));
                    inventoryButtonsList.get(i).addActionListener(new PutBackItem(game, game.getInventory().getItemsArray().get(i), frame));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (; i < 5; i ++) {
            inventoryButtonsList.get(i).setIcon(null);
        }
    }
}
