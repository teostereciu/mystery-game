package nl.ai.rug.oop.rpg.view;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JLayeredPane {
    //private Image background;
    private JLabel lbl = new JLabel("");
    private ForegroundPanel foregroundPanel;
    private MysteryGame game;

    public ForegroundPanel getForegroundPanel() {
        return foregroundPanel;
    }

    public BackgroundPanel(MysteryGame game) throws IOException {
        this.game = game;
        foregroundPanel = new ForegroundPanel(game);
        setPreferredSize(new Dimension(1067, 600));
        lbl.setBounds(0,0,1067,600);
        set(0);
    }
    public void removeBtnFromFG(int id) {
        foregroundPanel.removeBtn(id);
    }
    public void set(int roomIdx) throws IOException { // todo: 4csanad - use this to update background
        foregroundPanel.removeAll();
        removeAll();
        Image roomImg = ImageIO.read(new File("src/main/resources/rooms/room"+ roomIdx + ".png"));
        roomImg = roomImg.getScaledInstance(1067, 600, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(roomImg));
        add(lbl, (Integer)0);
        foregroundPanel.set(roomIdx);
        add(foregroundPanel, (Integer)1);
        SwingUtilities.updateComponentTreeUI(this);
    }

    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.scale(0.5, 0.5); // todo: change as needed
        g.drawImage(background, 0, 0, null);
        graphics2D.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(background.getWidth(this), background.getHeight(this));
    }*/
}
