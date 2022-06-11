package nl.ai.rug.oop.rpg.controller;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemChooser implements ActionListener {
    private MysteryGame modelGame;
    private Item modelItem;
    public ItemChooser(MysteryGame game, Item item){
        this.modelGame = game;
        this.modelItem = item;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // modelGame.getInventory(),addItemToInventory(item);
    }
}
