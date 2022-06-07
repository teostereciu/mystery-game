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
        Image eurImg = ImageIO.read(new File("src/main/resources/euro.png"));
        eurImg = eurImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton eurBtn = new JButton(new ImageIcon(eurImg));
        addNPCs(roomIdx);
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
            case 2:
                break;
        }
    }
    private void addNPCs(int roomIdx) throws IOException {
        switch (roomIdx) {
            case 0:
                Image staceyImg = ImageIO.read(new File("src/main/resources/stacey.png"));
                staceyImg = staceyImg.getScaledInstance((int) (staceyImg.getWidth(null)*1.3),(int) (staceyImg.getHeight(null)*1.3),Image.SCALE_SMOOTH);
                JButton staceyBtn = new JButton(new ImageIcon(staceyImg)); // todo: 4csanad - this button should start a dialogue (like all npc buttons)
                staceyBtn.setBounds(800, 280, staceyImg.getWidth(null), staceyImg.getHeight(null));
                staceyBtn.setOpaque(false);
                staceyBtn.setContentAreaFilled(false);
                staceyBtn.setBorderPainted(false);
                add(staceyBtn);
                break;
            case 1:
                Image daveyImg = ImageIO.read(new File("src/main/resources/davey.png"));
                daveyImg = daveyImg.getScaledInstance((int) (daveyImg.getWidth(null)*1.3),(int) (daveyImg.getHeight(null)*1.3),Image.SCALE_SMOOTH);
                JButton daveyBtn = new JButton(new ImageIcon(daveyImg)); // todo: 4csanad - this button should start a dialogue (like all npc buttons)
                daveyBtn.setBounds(800, 280, daveyImg.getWidth(null), daveyImg.getHeight(null));
                daveyBtn.setOpaque(false);
                daveyBtn.setContentAreaFilled(false);
                daveyBtn.setBorderPainted(false);
                add(daveyBtn);
                break;
            case 2:
                Image samImg = ImageIO.read(new File("src/main/resources/sam.png"));
                samImg = samImg.getScaledInstance((int) (samImg.getWidth(null)*1.3),(int) (samImg.getHeight(null)*1.3),Image.SCALE_SMOOTH);
                JButton samBtn = new JButton(new ImageIcon(samImg)); // todo: 4csanad - this button should start a dialogue (like all npc buttons)
                samBtn.setBounds(800, 280, samImg.getWidth(null), samImg.getHeight(null));
                samBtn.setOpaque(false);
                samBtn.setContentAreaFilled(false);
                samBtn.setBorderPainted(false);
                add(samBtn);
                break;
            case 3:
            case 4:
            case 5:
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
