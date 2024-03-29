package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.controller.*;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A class for the mystery game view frame.
 * @author teostereciu
 */
public class GameView extends JFrame implements PropertyChangeListener {
    private final MysteryGame game = new MysteryGame();
    public final int ROOM_WIDTH = 800;
    public final int ROOM_HEIGHT = 500;

    /**
     * Constructor for the game view frame.
     */
    public GameView() {
        init();
        initMenuBar();
        game.addListener(this);
    }

    /**
     * Initializes menu bar. Adds game option buttons.
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem giveUpItem = new JMenuItem("Give up!");
        giveUpItem.addActionListener(new GiveUpper(this));
        JMenuItem newGameItem = new JMenuItem("New game");
        newGameItem.addActionListener(new NewGame(this));
        JMenuItem saveGameItem = new JMenuItem("Save game");
        saveGameItem.addActionListener(new GameSaver(game, this));
        JMenuItem loadGameItem = new JMenuItem("Load game");
        loadGameItem.addActionListener(new GameLoader(game, this));
        menu.add(giveUpItem);
        menu.add(newGameItem);
        menu.add(saveGameItem);
        menu.add(loadGameItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * Initialize the game frame.
     */
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
    private final NavigationPanel navigationPanel = new NavigationPanel(game, this);
    private final RoomPanel roomPanel = new RoomPanel(game, this);

    /**
     * Sets the panels. Used for initial set-up.
     */
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

    /**
     * Updates the frame.
     */
    public void updateRoom() {
        roomPanel.set();
        navigationPanel.changeDestination(0);
        navigationPanel.enableNavigateButton(game.getCurrentRoomNum() != 0);
        locationPanel.update(game.getCurrentRoomNum());
        dialoguePanel.clear();
        inventoryPanel.update();
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Used for close-ups on items.
     * @param item
     */
    public void closeUp(Item item) {
        roomPanel.closeUpOnItem(item.getItemName());
        navigationPanel.changeDestination(game.getCurrentRoomNum());
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (game.getRoom(0).getNPC().getNPCDialogue().getCurrentKey() != 412) {
            updateRoom();
        } else {
            displayEnding();
        }
    }

    /**
     * Used to update the dialogue panel.
     */
    public void updateDialoguePanel() {
        dialoguePanel.update();
    }

    /**
     * Displays pop-out to let the player insert a safe code.
     * @return the code as String
     */
    public String displayInsertSafeCodeDialog() {
        return JOptionPane.showInputDialog("I need to use a special code to open the safe.");
    }

    /**
     * Displays outcome message after inserting a safe code.
     * @param isCorrect
     */
    public void displaySafeDialog(boolean isCorrect) {
        if (isCorrect) {
            JOptionPane.showMessageDialog(this, "The code worked! The safe is now open. I should investigate what is inside.",
                    "Opened safe", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "The code did not work! The safe remains closed.",
                    "Failed to open safe", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Displays warnings and questions related to game options.
     * @param type
     * @return choice
     */
    public int displayGameOptions(int type) {
        switch(type) {
            case 0 -> {
            String[] options = {"Cancel", "Save"};
                return JOptionPane.showOptionDialog(null,"Do you want to save current game? This will overwrite any previous savings.","Save game", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, options, null);
            }
            case 1 -> {
                String[] options = {"Cancel", "Load"};
                return JOptionPane.showOptionDialog(null,"Do you want to load game? Any unsaved progress will be lost.","Load game", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, options, null);
            }
            case 2 -> {
                String[] options = {"Cancel", "Give up"};
                return JOptionPane.showOptionDialog(null,"Do you want to give up? Any unsaved progress will be lost.","Give up", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null, options, null);
            }
        }
        return 0;
    }

    /**
     * Displays ending screen.
     */
    public void displayEnding() {
        roomPanel.updateToEnding();
        add(roomPanel);
    }

    /**
     * Displays warnings/questions related to game play.
     * @param type
     * @return choices
     */
    public int displayDetectiveWarnings(int type) {
        switch (type) {
            case 0 -> JOptionPane.showMessageDialog(this, "Cannot drop item here.",
                        "Failed to put back item", JOptionPane.WARNING_MESSAGE);
            case 1 -> JOptionPane.showMessageDialog(this, "Cannot use item here.", //todo remove?
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 2 -> JOptionPane.showMessageDialog(this, "Inventory is full. I should drop an item before trying to pick up a new one.",
                            "Failed to add item to inventory", JOptionPane.WARNING_MESSAGE);
            case 3 -> {
                String[] options = {"Drop", "Use"};
                return JOptionPane.showOptionDialog(null,"What should I do with this item?","Drop/Use item.", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, options, null);
            }
            case 4 -> JOptionPane.showMessageDialog(this, "I do not have access to this room.",
                    "Failed to enter room", JOptionPane.WARNING_MESSAGE);
            case 5 -> JOptionPane.showMessageDialog(this, "I do not know what to do with this item yet.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 6 -> JOptionPane.showMessageDialog(this, "Cannot use this item in this room.",
                    "Failed to use item", JOptionPane.WARNING_MESSAGE);
            case 7 -> JOptionPane.showMessageDialog(this, "I do not know how to interact with this yet. I should gather more information first.",
                    "Failed to interact", JOptionPane.WARNING_MESSAGE);
            case 8 -> JOptionPane.showMessageDialog(this, "I found the stolen beer crate and a bandage is ripped onto it! I need to tell Stacey what happened.",
                    "Failed to interact", JOptionPane.WARNING_MESSAGE);
            case 10 -> JOptionPane.showMessageDialog(this, "<html>You chose bad cop! You are a private investigator. <p>Stacey hired you to find out who stole the beer that she got for her graduation party.</p><p>Here she is, in the Hallway.</p></html>",
                    "Intro", JOptionPane.WARNING_MESSAGE);
            case 11 -> JOptionPane.showMessageDialog(this, "<html>You chose good cop! You are a private investigator. <p>Stacey hired you to find out who stole the beer that she got for her graduation party.</p><p>Here she is, in the Hallway.</p></html>",
                        "Intro", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
}
