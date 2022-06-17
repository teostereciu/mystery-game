package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.SelectInventoryItem;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A JPanel for the inventory. Shows the items the player is carrying.
 */
public class InventoryPanel extends JPanel {
    private ArrayList<JButton> inventoryButtonsList = new ArrayList<>();
    private final MysteryGame game;
    private final GameView frame;

    /**
     * Constructor for the inventory panel.
     * @param game
     * @param frame
     */
    public InventoryPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setPreferredSize(new Dimension(120, 500));
        GridLayout gridLayout = new GridLayout(game.TOTAL_INVENTORY_SLOTS + 1, 1);
        setLayout(gridLayout);
        setBackground(Color.black);
        JButton button = newEmptyButton();
        button.setText("Inventory");
        for (int i = 1; i <= game.TOTAL_INVENTORY_SLOTS; i ++) {
            inventoryButtonsList.add(newEmptyButton());
        }
    }

    /**
     * Creates, adds, and returns a new JButton for inventory.
     * @return the button
     */
    private JButton newEmptyButton() {
        JButton jButton = new JButton();
        jButton.setForeground(Color.white);
        jButton.setBackground(Color.black);
        add(jButton);
        return jButton;
    }

    /**
     * Updates the inventory.
     */
    public void update() {
        int i;
        for (i = 0; i < game.getInventory().getItemsArray().size(); i ++) {

            if (inventoryButtonsList.get(i).getActionListeners().length != 0) {
                inventoryButtonsList.get(i).removeActionListener(inventoryButtonsList.get(i).getActionListeners()[0]);
            }

            if (game.getInventory().getItemsArray().get(i) != null) {
                String name = game.getInventory().getItemsArray().get(i).getItemName();
                try {
                    Image slotImage = ImageIO.read(new File("src/main/resources/items/" + name + ".png"));
                    inventoryButtonsList.get(i).setIcon(new ImageIcon(slotImage));
                    inventoryButtonsList.get(i).addActionListener(new SelectInventoryItem(game, game.getInventory().getItemsArray().get(i), frame));
                } catch (IOException e) {
                    System.out.println("src/main/resources/items/" + name + ".png not found.");
                    throw new RuntimeException(e);
                }
            }
        }

        for (; i < game.TOTAL_INVENTORY_SLOTS; i ++) {
            if (inventoryButtonsList.get(i).getActionListeners().length != 0) {
                inventoryButtonsList.get(i).removeActionListener(inventoryButtonsList.get(i).getActionListeners()[0]);
            }
            inventoryButtonsList.get(i).setIcon(null);
        }
    }
}
