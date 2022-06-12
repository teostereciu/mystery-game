package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PutBackItem implements ActionListener {
    private MysteryGame modelGame;
    private Item modelItem;
    private GameView viewFrame;
    public PutBackItem(MysteryGame game, Item item, GameView frame) {
        this.modelGame = game;
        this.modelItem = item;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (modelItem.getRoomNumber() == modelGame.getCurrentRoomNum()) {
            modelGame.updateInventory(modelItem, 0);
        } else {
            viewFrame.displayErrorMessage(0);
            // todo 4 some reason this happens a bunch of times after just one click csanad pls fix
        }
    }
}
