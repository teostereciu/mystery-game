package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
        revalidate();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mystery Game"); // todo: find a different title for the game?
        setSize(800, 600); // todo: change(?)
        //this.getContentPane().setBackground(new Color(0, 102, 51)); // todo: remove
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));
        //backgroundPanel.setImage(readImage(new File("src/main/resources/room0.png"))); // todo: remove
        //setContentPane(backgroundPanel); // todo: remove
        setPanels(game);
        revalidate();
        setVisible(true);
    }
    private BackgroundPanel backgroundPanel = new BackgroundPanel();
    private InventoryPanel inventoryPanel = new InventoryPanel();
    private DialoguePanel dialoguePanel = new DialoguePanel();
    private LocationPanel locationPanel = new LocationPanel();
    private NavigationPanel navigationPanel = new NavigationPanel();
    private BufferedImage readImage(File file) {
        try {
            return (BufferedImage) ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void setPanels(MysteryGame game) {
        backgroundPanel.setImage(readImage(new File("src/main/resources/room0.png")));
        add(backgroundPanel, BorderLayout.CENTER);
        add(inventoryPanel, BorderLayout.EAST);
        add(dialoguePanel, BorderLayout.SOUTH);
        add(locationPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.WEST);
    }

    private void updateRoom(int roomIdx) {
        backgroundPanel.setImage(readImage((new File("src/main/resources/room/" + roomIdx + ".png"))));
        locationPanel.update(roomIdx);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
