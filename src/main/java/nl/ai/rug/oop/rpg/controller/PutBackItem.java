package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PutBackItem implements ActionListener {
    private MysteryGame modelGame;
    private Item modelItem;
    public PutBackItem(MysteryGame game, Item item) {
        this.modelGame = game;
        this.modelItem = item;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(modelItem.getRoomNumber()== modelGame.getCurrentRoom()){
            modelGame.updateInventory(modelItem, 0);
        } else {
            // todo: 4teo notify user that not in right room
        }
    }
}
