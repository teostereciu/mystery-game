package nl.ai.rug.oop.rpg.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ForegroundPanel extends JPanel {
    private ArrayList<JButton> btns = new ArrayList<>();
    public void set(int roomIdx) throws IOException {
        setLayout(null);
        setBounds(0,0,1067,600);
        setOpaque(false);
        btns.clear();
        switch(roomIdx) {
            case 0:
                addDoorBtns();
                btns.add(newBtn("euro", 0.05, 520,150));
                btns.add(newBtn("stacey", 1.3, 800, 280));
                btns.add(newBtn("cleaning-supplies", 0.2, 130, 400));
                break;
            case 1:
                btns.add(newBtn("davey", 1.4, 800, 280));
                break;
            case 2:
                btns.add(newBtn("sam", 1.3, 800, 280));
                break;
            case 3:
                btns.add(newBtn("kyle", 1.3, 800, 280));
            case 4:
                btns.add(newBtn("alex", 1.3, 800, 280));
            case 5:
                btns.add(newBtn("melvin", 1.3, 800, 280));
            case 6:

        }
    }
    private JButton newBtn(String name, double scale, int x, int y) throws IOException { // todo: 4csanad stuff here
        Image img = ImageIO.read(new File("src/main/resources/" + name + ".png"));
        img = img.getScaledInstance((int) (img.getWidth(null) * scale), (int) (img.getHeight(null) * scale), Image.SCALE_SMOOTH);
        JButton btn = new JButton(new ImageIcon(img));
        btn.setBounds(x, y, img.getWidth(null), img.getHeight(null));
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        add(btn);
        return btn;
    }

    protected void removeBtn(int id) { // todo: find a way to id the buttons in the model 4daniel
        remove(btns.get(id));
    }

    private void addDoorBtns() { // todo: 4csanad - functionality for these buttons
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 6; i ++) {
            btns.add(new JButton());
            btns.get(i).setOpaque(false);
            btns.get(i).setContentAreaFilled(false);
            btns.get(i).setBorderPainted(false);
            switch (i) {
                case 0 -> btns.get(i).setBounds(40, 270, 110, 210); // note: this leads to room1 (living room)
                case 1 -> btns.get(i).setBounds(210, 250, 100, 200);
                case 2 -> btns.get(i).setBounds(380, 250, 100, 200);
                case 3 -> btns.get(i).setBounds(570, 250, 100, 200);
                case 4 -> btns.get(i).setBounds(760, 250, 100, 200);
                case 5 -> btns.get(i).setBounds(920, 270, 110, 210);
            }
            add(btns.get(i));
        }
    }
}
