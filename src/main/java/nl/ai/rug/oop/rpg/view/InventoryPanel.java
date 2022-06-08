package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryPanel extends JPanel {
    private ArrayList<JButton> btnList = new ArrayList<>();
    final int SIZE = 5;
    public InventoryPanel() {
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
    public void addItem(String name, double scale, int slot) throws IOException { // todo: make sure empty slot is being kept track of in model
        Image img = ImageIO.read(new File("src/main/resources/" + name + ".png"));
        img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        btnList.get(slot).setIcon(new ImageIcon(img)); //todo: 4csanad - use this when adding an item to the inventory
    } // note: idea, itm.getImage() and itm.setImage() in model? also with npcs todo: 4daniel
    public void removeItem(int slot) {
        btnList.get(slot).setIcon(new ImageIcon());
    } // todo: 4csanad - discard item with this
}
