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
        btn.setText("Inventory"); // todo: 4csanad idk
        btnList.add(newEmptyButton()); // todo: 4csanad - discard item
        btnList.add(newEmptyButton());
        btnList.add(newEmptyButton());
        btnList.add(newEmptyButton());
    }
    private JButton newEmptyButton() { // todo: ehh design
        JButton jButton = new JButton();
        jButton.setOpaque(true);
        jButton.setBorderPainted(true);
        jButton.setBackground(Color.black);
        add(jButton);
        return jButton;
    }
    public void addItem(Item item, int slot) { // todo: make sure empty slot is being kept track of in model
        //btnList.get(slot).setIcon(new ImageIcon(item.getImage())); // todo: this image icon business. 4daniel - implement getImage() or sth like this. If you give me a setImage I can help with reading it from file. 4csanad - use this when adding an item to the inventory
    }
    public void removeItem(int slot) {
        btnList.get(slot).setIcon(new ImageIcon());
    }
}
