package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.SelectInventoryItem;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private ArrayList<JButton> inventoryButtonsList = new ArrayList<>();
    //JComboBox<String> itemOptionsComboBox;
    private final MysteryGame game;
    private final GameView frame;
    final int SIZE = 5; // todo replace with cont from model
    public InventoryPanel(MysteryGame game, GameView frame) {
        this.game = game;
        this.frame = frame;
        setPreferredSize(new Dimension(100, 500));
        GridLayout gridLayout = new GridLayout(SIZE + 1, 1);
        setLayout(gridLayout);
        //setOpaque(false);
        setBackground(Color.black);
        //add(new JButton("Hint"));
        JButton btn = newEmptyButton();
        btn.setText("Inventory"); // todo: 4csanad idk - could hide/reveal the item list. or some instructions
        //String[] itemOptions = {"Use item", "Put back item"};
        for (int i = 1; i <= SIZE; i ++) {
            //itemOptionsComboBox = new JComboBox<>(itemOptions);
            //add(itemOptionsComboBox);
            //itemOptionsComboBox.setVisible(false);
            //itemOptionsComboBox.setBackground(Color.black);
            inventoryButtonsList.add(newEmptyButton());
        }
    }
    private JButton newEmptyButton() {
        JButton jButton = new JButton();
        //jButton.setOpaque(true);
        //jButton.setBorderPainted(true);
        jButton.setBackground(Color.orange); //todo check from windows how these look
        add(jButton);
        return jButton;
    }

    public void update() {
        int i;
        for (i = 0; i < game.getInventory().getItemsArray().size(); i ++) {
            if (inventoryButtonsList.get(i).getActionListeners().length != 0) {
                inventoryButtonsList.get(i).removeActionListener(inventoryButtonsList.get(i).getActionListeners()[0]);
            }
            if (game.getInventory().getItemsArray().get(i) != null) {
                String name = game.getInventory().getItemsArray().get(i).getItemName();
                try {
                    //if (inventoryButtonsList.get(i).getActionListeners().length == 0) {
                        //System.out.println("Action listener added to " + name + "in slot " + i);
                        inventoryButtonsList.get(i).addActionListener(new SelectInventoryItem(game, game.getInventory().getItemsArray().get(i), frame));
                    //}
                    //inventoryButtonsList.get(i).removeActionListener(inventoryButtonsList.get(i).getActionListeners()[0]);
                    inventoryButtonsList.get(i).setIcon(new ImageIcon(ImageIO.read(new File("src/main/resources/items/" + name + ".png"))));
                    //inventoryButtonsList.get(i).addActionListener(new PutBackItem(game, game.getInventory().getItemsArray().get(i), frame));

                    //inventoryButtonsList.get(i).addActionListener(new ShowItemOptions(game));
                    //itemOptionsComboBox.addActionListener(new UseItem(game, game.getInventory().getItemsArray().get(i), frame));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (; i < SIZE; i ++) {
            inventoryButtonsList.get(i).setIcon(null);
        }
    }
}
