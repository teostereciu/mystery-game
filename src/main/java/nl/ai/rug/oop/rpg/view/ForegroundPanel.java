package nl.ai.rug.oop.rpg.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ForegroundPanel extends JPanel {
    public void set(int roomIdx) throws IOException {
        setLayout(null);
        setBounds(0,0,1067,600);
        setOpaque(false);
        //JButton eurBtn = new JButton(new ImageIcon(ImageIO.read(new File("src/main/resources/euro.png"))));
        Image eurImg = ImageIO.read(new File("src/main/resources/euro.png"));
        eurImg = eurImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton eurBtn = new JButton(new ImageIcon(eurImg));
        switch(roomIdx) {
            case 0:
                addDoorBtns();
                eurBtn.setBounds(600,500,50,50);
                eurBtn.setOpaque(false);
                eurBtn.setContentAreaFilled(false);
                eurBtn.setBorderPainted(false);
                add(eurBtn);
                break;
            case 1:
                break;
        }
    }
    private void addDoorBtns() { // todo: 4csanad - functionality for these buttons
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 6; i ++) {
            btns.add(new JButton("test" + i));
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
