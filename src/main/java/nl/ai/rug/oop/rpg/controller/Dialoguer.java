package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialoguer implements ActionListener {
    private MysteryGame modelGame;
    public Dialoguer(MysteryGame game){
        this.modelGame = game;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.getRoom(modelGame.getCurrentRoom()).getNPC().getDialogue().increaseLine();
    }
}
