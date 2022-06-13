package nl.ai.rug.oop.rpg.controller;

import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemUser implements ActionListener {
    private MysteryGame modelGame;
    private Item modelItem;
    private GameView viewFrame;
    public ItemUser(MysteryGame game, Item item, GameView frame){
        this.modelGame = game;
        this.modelItem = item;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(modelItem.getIsCarryAble() == 0){
            //do something
        }
    }
}
