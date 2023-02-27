package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for entering a room.
 * @author veghcsanad
 */
public class RoomChooser implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;
    private int destIdx;

    /**
     * Constructor of the RoomChooser class.
     * @param game
     * @param destIdx
     * @param frame
     */

    public RoomChooser(MysteryGame game, int destIdx, GameView frame){
        this.modelGame = game;
        this.destIdx = destIdx;
        this.viewFrame = frame;
    }

    /**
     * Called when a door is clicked.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(modelGame.getCurrentRoomNum()==5){
            modelGame.setFlashlightIsOn(false);
        }
        if(modelGame.getRoom(destIdx).getIsOpen()){
            modelGame.setCurrentRoomNum(destIdx);
        } else {
            viewFrame.displayDetectiveWarnings(4);
        }
    }
}
