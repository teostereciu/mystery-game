package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/**
 * A class for the mystery game view.
 * @author teo stereciu
 */
public class GameView extends JFrame implements PropertyChangeListener {
    private final MysteryGame game = new MysteryGame();
    public final int ROOM_WIDTH = 800;
    public final int ROOM_HEIGHT = 500;
    public GameView() {
        init();
        game.addListener(this);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mystery Game");
        setLayout(new BorderLayout(0, 0));
        setResizable(false);
        //setBackground(Color.black);
        add(roomPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private final InventoryPanel inventoryPanel = new InventoryPanel(game, this);
    private final DialoguePanel dialoguePanel = new DialoguePanel(game, this);
    private final LocationPanel locationPanel = new LocationPanel();
    private final NavigationPanel navigationPanel = new NavigationPanel(game, this);
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

    public int displayDialog(int i) {
        switch (i) {
            case 0 -> JOptionPane.showMessageDialog(this, "Cannot drop item here.",
                        "Failed to put back item", JOptionPane.WARNING_MESSAGE);
            case 1 -> JOptionPane.showMessageDialog(this, "Cannot use item here.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 2 -> JOptionPane.showMessageDialog(this, "Inventory is full. Drop an item before trying to add a new one.",
                            "Failed to add item to inventory", JOptionPane.WARNING_MESSAGE);
            case 3 -> {
                String[] options = {"Drop", "Use"};
                return JOptionPane.showOptionDialog(null,"What do you want to do with this item?","Drop/Use item.", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, options, null);
            }
            case 4 -> JOptionPane.showMessageDialog(this, "You do not have access to this room.",
                    "Failed to enter room", JOptionPane.WARNING_MESSAGE);
            case 5 -> JOptionPane.showMessageDialog(this, "You cannot use this item yet.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 6 -> JOptionPane.showMessageDialog(this, "You cannot use this item in this room.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
}
