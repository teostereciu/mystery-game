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
    private final MysteryGame game = new MysteryGame(); // note: update this if constructor changes
    public GameView() {
        init();
        revalidate();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mystery Game");
        setSize(960, 580);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));
        setResizable(false);
        try {
            setPanels();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        game.addListener(this);
        revalidate();
        setVisible(true);
    }
    private InventoryPanel inventoryPanel = new InventoryPanel();
    private DialoguePanel dialoguePanel = new DialoguePanel();
    private LocationPanel locationPanel = new LocationPanel();
    private NavigationPanel navigationPanel = new NavigationPanel(game);
    private BackgroundPanel backgroundPanel;
    /*private BufferedImage readImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    private void setPanels() throws IOException {
        try {
            backgroundPanel = new BackgroundPanel(game);
        } catch (IOException e) {
            System.out.println("File not found.");
            throw new RuntimeException();
        }
        add(backgroundPanel, BorderLayout.CENTER);
        add(inventoryPanel, BorderLayout.EAST);
        add(dialoguePanel, BorderLayout.SOUTH);
        add(locationPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.WEST);
        /*try {
            inventoryPanel.addItem("euro",0.1,0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //backgroundPanel.removeBtnFromFG(0);
        //updateRoom(1);
        //updateRoom(2);
        /*try {
            Image eurImg = ImageIO.read(new File("src/main/resources/euro.png"));
            eurImg = eurImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            inventoryPanel.addItem(eurImg, 1);
            inventoryPanel.removeItem(1);
        } catch(IOException ignored) {

        }*/
    }

    private void updateRoom(int roomIdx) throws IOException { // todo learn/decide what to do with IOExceptions
        backgroundPanel.set(roomIdx);
        navigationPanel.enableBtn(roomIdx != 0);
        locationPanel.update(roomIdx);
        SwingUtilities.updateComponentTreeUI(this);
        SwingUtilities.updateComponentTreeUI(backgroundPanel);
        SwingUtilities.updateComponentTreeUI(navigationPanel);
        SwingUtilities.updateComponentTreeUI(locationPanel);
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
            updateRoom(game.getCurrentRoom());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
