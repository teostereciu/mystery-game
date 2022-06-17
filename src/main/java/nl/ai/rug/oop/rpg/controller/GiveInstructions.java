package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiveInstructions implements ActionListener {
    private GameView viewFrame;
    public GiveInstructions(GameView frame) {
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        viewFrame.displayGameOptions(3);
    }
}
