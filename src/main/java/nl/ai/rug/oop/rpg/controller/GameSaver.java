package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSaver implements ActionListener {
    private MysteryGame modelGame;
    public GameSaver(MysteryGame game){
        this.modelGame = game;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.saveGame();
    }
}
