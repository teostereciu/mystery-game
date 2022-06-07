package nl.ai.rug.oop.rpg.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BackgroundPanel extends JLayeredPane {
    private Image background;
    private JLabel lbl = new JLabel("");
    public BackgroundPanel(Image background) {
        setPreferredSize(new Dimension(1067, 600));
        lbl.setBounds(0,0,1067,600);
        lbl.setIcon(new ImageIcon(background));
        add(lbl, (Integer)0);
        addBtns();
    }
    private void addBtns() {
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 6; i ++) {
            btns.add(new JButton("test" + i));
            btns.get(i).setOpaque(false);
            btns.get(i).setContentAreaFilled(false);
            btns.get(i).setBorderPainted(false);
            switch (i) {
                case 0 -> btns.get(i).setBounds(40, 270, 110, 210);
                case 1 -> btns.get(i).setBounds(210, 250, 100, 200);
                case 2 -> btns.get(i).setBounds(380, 250, 100, 200);
                case 3 -> btns.get(i).setBounds(570, 250, 100, 200);
                case 4 -> btns.get(i).setBounds(760, 250, 100, 200);
                case 5 -> btns.get(i).setBounds(920, 270, 110, 210);
            }
            add(btns.get(i), (Integer)1);
        }
    }
    public void setImage(Image background) {
        lbl.setIcon(new ImageIcon(background));
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
