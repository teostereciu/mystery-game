package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoader implements ActionListener {
    private MysteryGame modelGame;
    public GameLoader(MysteryGame game){
        this.modelGame = game;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.loadGame();
    }
}