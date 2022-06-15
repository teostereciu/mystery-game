package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomChooser implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;
    private int destIdx;

    public RoomChooser(MysteryGame game, int destIdx, GameView frame){
        this.modelGame = game;
        this.destIdx = destIdx;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(modelGame.getCurrentRoomNum()==5){
            modelGame.setFlashlightIsOn(false);
        }
        if(modelGame.getRoom(destIdx).getIsOpen() == true){
            modelGame.setCurrentRoomNum(destIdx);
            //if(destIdx != 6){
                //modelGame.updateDialogue();
                //viewFrame.updateDialoguePanel();
            //}
        } else {
            viewFrame.displayDialog(4);
        }
    }
}
