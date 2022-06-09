package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomChooser implements ActionListener {
    private MysteryGame modelGame;
    private int destIdx;
    public RoomChooser(MysteryGame modelGame, int destIdx){
        this.modelGame = modelGame;
        this.destIdx = destIdx;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modelGame.setCurrentRoom(destIdx);
    }
}
