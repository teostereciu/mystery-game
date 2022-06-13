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
        int result = viewFrame.displayDialog(3);
        if (result == 0) {
            if (modelItem.getRoomNumber() == modelGame.getCurrentRoomNum()) {
                modelGame.updateInventory(modelItem, 0);
            } else {
                viewFrame.displayDialog(0);
            }
        } else {
            // USE ITEM; // todo csanad
        }
    }
}
