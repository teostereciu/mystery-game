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
        /*JLayeredPane welcomePanel = new JLayeredPane();
        JLabel bgLabel = new JLabel();
        bgLabel.setBounds(0, 0, 800, 500);
        welcomePanel.setBounds(0, 0, 800, 500);
        try {
            Image bgImage = ImageIO.read(new File("src/main/resources/detective-choice.png"));
            bgLabel.setIcon(new ImageIcon(bgImage));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        welcomePanel.add(bgLabel, 0);
        JPanel choicePanel = new JPanel(null);
        choicePanel.setBounds(0, 0, 800, 500);
        JButton goodCopButton = new JButton();
        JButton badCopButton = new JButton();
        goodCopButton.setBounds(190, 60, 180, 160);
        badCopButton.setBounds(400, 60, 180, 160);

        choicePanel.add(goodCopButton);
        choicePanel.add(badCopButton);
        welcomePanel.add(choicePanel, 1);
        add(welcomePanel, BorderLayout.CENTER);
        setVisible(true);*/
        /**/
        //pack();
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
    private InventoryPanel inventoryPanel = new InventoryPanel();
    private DialoguePanel dialoguePanel = new DialoguePanel(game);
    private LocationPanel locationPanel = new LocationPanel();
    private NavigationPanel navigationPanel = new NavigationPanel(game);
    private RoomPanel roomPanel = new RoomPanel(game, this);
    public void setPanels() {
        //setSize(960, 580);
        //try {

        //} catch (IOException e) {
        //    System.out.println("File not found.");
        //    throw new RuntimeException();
        //}

        add(inventoryPanel, BorderLayout.EAST);
        add(dialoguePanel, BorderLayout.SOUTH);
        add(locationPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.WEST);
        roomPanel.init();
        add(roomPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

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

    private void updateRoom() throws IOException {
        roomPanel.set();
        navigationPanel.enableBtn(game.getCurrentRoom() != 0);
        locationPanel.update(game.getCurrentRoom());
        dialoguePanel.clear();
        SwingUtilities.updateComponentTreeUI(this);
        SwingUtilities.updateComponentTreeUI(roomPanel);
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
            //System.out.println("Update room from " + game.getPreviousRoomIdx() + " to " + game.getCurrentRoom());
            updateRoom();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDialoguePanel() {
        dialoguePanel.update();
    }
}
