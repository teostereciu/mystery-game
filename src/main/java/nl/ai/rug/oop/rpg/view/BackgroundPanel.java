package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class BackgroundPanel extends JLayeredPane {
    //private Image background;
    private JLabel lbl = new JLabel("");
    private ForegroundPanel foregroundPanel = new ForegroundPanel();
    public BackgroundPanel(Image background) {
        setPreferredSize(new Dimension(1067, 600));
        lbl.setBounds(0,0,1067,600);
        lbl.setIcon(new ImageIcon(background));
        add(lbl, (Integer)0);
        try {
            foregroundPanel.set(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        add(foregroundPanel, (Integer)1);
    }

    public void setImage(Image background, int roomIdx) { // todo: 4csanad - use this to update background
        removeAll();
        lbl.setIcon(new ImageIcon(background));
        add(lbl, (Integer)0);
        try {
            foregroundPanel.set(roomIdx);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        add(foregroundPanel, (Integer)1);
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
