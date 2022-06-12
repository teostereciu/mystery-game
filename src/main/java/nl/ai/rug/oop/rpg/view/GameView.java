package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

/**
 * A class for the mystery game view.
 * @author teo stereciu
 */
public class GameView extends JFrame implements PropertyChangeListener {
    private final MysteryGame game = new MysteryGame(); // note: update this if constructor changes
    public GameView() {
        init();
        game.addListener(this);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mystery Game");
        setLayout(new BorderLayout(0, 0));
        setResizable(false);
        add(roomPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private final InventoryPanel inventoryPanel = new InventoryPanel(game, this);
    private final DialoguePanel dialoguePanel = new DialoguePanel(game, this);
    private final LocationPanel locationPanel = new LocationPanel();
    private final NavigationPanel navigationPanel = new NavigationPanel(game);
    private final RoomPanel roomPanel = new RoomPanel(game, this);

    public void setPanels() {
        add(inventoryPanel, BorderLayout.EAST);
        add(dialoguePanel, BorderLayout.SOUTH);
        add(locationPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.WEST);
        roomPanel.init();
        add(roomPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateRoom() throws IOException {
        roomPanel.set();
        navigationPanel.enableNavigateButton(game.getCurrentRoomNum() != 0);
        locationPanel.update(game.getCurrentRoomNum());
        dialoguePanel.clear();
        inventoryPanel.update();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void updateInventoryPanel() {
        inventoryPanel.update();
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            updateRoom();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDialoguePanel() {
        dialoguePanel.update();
    }

    public void displayErrorMessage(int i) {
        switch (i) {
            case 0 -> {
                System.out.println("Failed to put down item");
                JOptionPane.showMessageDialog(this, "Can't put back item here.",
                        "Failed to put back item", JOptionPane.WARNING_MESSAGE);
            }
            case 1 -> JOptionPane.showMessageDialog(this, "Can't use item here.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 2 ->
                    JOptionPane.showMessageDialog(this, "Inventory is full. Put back an item before trying to add a new one.",
                            "Failed to add item to inventory", JOptionPane.WARNING_MESSAGE);
        }
    }
}
