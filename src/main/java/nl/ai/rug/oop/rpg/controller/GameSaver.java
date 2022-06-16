package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSaver implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;
    public GameSaver(MysteryGame game, GameView frame) {
        this.modelGame = game;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int outcome = viewFrame.displayDialog(8);
        if (outcome == 1) {
            modelGame.saveGame();
        }
    }
}
