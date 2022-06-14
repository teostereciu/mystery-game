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
        int response = viewFrame.displayDialog(3);
        //System.out.println("You clicked an inventory item!");
        if (response == 0) {
            //System.out.println("You chose to drop it!");
            if (modelItem.getRoomNumber() == modelGame.getCurrentRoomNum()) {
                //System.out.println("Item was dropped!");
                modelGame.updateInventory(modelItem, 0);
            } else {
                //System.out.println("You could not be dropped!");
                viewFrame.displayDialog(0);
            }
        } else if (response == 1) {
            int outcome = modelGame.updateProgress(modelItem);
            if(outcome == 2){
                viewFrame.displayDialog(5);
            } else if(outcome == 3){
                viewFrame.displayDialog(6);
            }
        }
    }
}