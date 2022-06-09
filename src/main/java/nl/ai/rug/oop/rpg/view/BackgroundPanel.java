package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BackgroundPanel extends JLayeredPane {
    private JLabel lbl = new JLabel("");
    private final ArrayList<ImageIcon> bgImageIcons = new ArrayList<>();
    private final ArrayList<ForegroundPanel> foregroundPanelArrayList = new ArrayList<>();
    //private ForegroundPanel foregroundPanel;
    private MysteryGame game;

    public BackgroundPanel(MysteryGame game) throws IOException {
        this.game = game;
        setPreferredSize(new Dimension(800, 500));
        lbl.setBounds(0,0,800,500);
        add(lbl, (Integer) 0);
        for (int roomIdx = 0; roomIdx < 2; roomIdx ++) { //game.getNumberOfRooms()
            foregroundPanelArrayList.add(new ForegroundPanel(game, roomIdx));
            foregroundPanelArrayList.get(roomIdx).setVisible(false);
            add(foregroundPanelArrayList.get(roomIdx), (Integer) (roomIdx + 1));
            bgImageIcons.add(new ImageIcon(ImageIO.read(new File("src/main/resources/rooms/room" + roomIdx + ".png"))));
        }
        set(0,0);
    }
    public void set(int prevIdx, int destIdx) {
        lbl.setIcon(bgImageIcons.get(destIdx));
        foregroundPanelArrayList.get(prevIdx).setVisible(false);
        foregroundPanelArrayList.get(prevIdx).setEnabled(false);
        foregroundPanelArrayList.get(destIdx).setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public ForegroundPanel getForegroundPanel() {
        return foregroundPanelArrayList.get(game.getCurrentRoom());
    }


    public void removeBtnFromFG(int id) {
        //foregroundPanel.removeBtn(id);
    }
    /*public void set(int roomIdx) throws IOException { // todo: 4csanad - use this to update background
        foregroundPanel.removeAll();
        removeAll();
        Image roomImg = ImageIO.read(new File("src/main/resources/rooms/pxroom"+ roomIdx + ".png"));
        //roomImg = roomImg.getScaledInstance(1067, 600, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(roomImg));
        add(lbl, (Integer)0);
        foregroundPanel.set(roomIdx);
        add(foregroundPanel, (Integer)1);
        SwingUtilities.updateComponentTreeUI(this);
    }*/


}
