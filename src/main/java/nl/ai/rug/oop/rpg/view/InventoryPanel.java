package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private ArrayList<JButton> btnList = new ArrayList<>();
    public InventoryPanel() {
        GridLayout gridLayout = new GridLayout(5, 1);
        //setBackground(new Color(0, 102, 51)); // todo: remove
        setLayout(gridLayout);
        setOpaque(false);
        JButton btn = newEmptyButton();
        btn.setText("Inventory"); // todo: maybe this can hide/reveal the items
        btnList.add(newEmptyButton());
        btnList.add(newEmptyButton());
        btnList.add(newEmptyButton());
        btnList.add(newEmptyButton());
    }
    private JButton newEmptyButton() { // todo: design
        JButton jButton = new JButton();
        jButton.setOpaque(true);
        jButton.setBorderPainted(true);
        jButton.setBackground(Color.black);
        add(jButton);
        return jButton;
    }
    public void addItem(Item item, int slot) { // todo: make sure empty slot is being kept track of in model
        btnList.get(slot).setIcon(new ImageIcon()); // todo: this image icon business
    }
    public void removeItem(int slot) {
        btnList.get(slot).setIcon(new ImageIcon());
    }
}
