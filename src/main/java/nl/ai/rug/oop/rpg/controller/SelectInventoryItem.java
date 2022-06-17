package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectInventoryItem implements ActionListener {
    private MysteryGame modelGame;
    private Item modelItem;
    private GameView viewFrame;
    public SelectInventoryItem(MysteryGame game, Item item, GameView frame) {
        this.modelGame = game;
        this.modelItem = item;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int response = viewFrame.displayDetectiveWarnings(3);
        if (response == 0) {
            if (modelItem.getRoomNumber() == modelGame.getCurrentRoomNum()) {
                modelGame.updateInventory(modelItem, 0);
            } else {
                viewFrame.displayDetectiveWarnings(0);
            }
        } else if (response == 1) {
            int outcome = modelGame.updateProgress(modelItem);
            if(outcome == 2){
                viewFrame.displayDetectiveWarnings(5);
            } else if(outcome == 3){
                viewFrame.displayDetectiveWarnings(6);
            } else {
                //modelGame.updateDialogue();
                //viewFrame.updateDialoguePanel(); //todo: remove
            }
        }
    }
}