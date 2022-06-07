package nl.ai.rug.oop.rpg.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image background;

    public void setImage(Image background) {
        this.background = background;
        setLayout(new BorderLayout());
    }

    @Override
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
    }
}
