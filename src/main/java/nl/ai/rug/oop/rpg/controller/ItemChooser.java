package nl.ai.rug.oop.rpg.controller;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemChooser implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;
    private Item modelItem;
    public ItemChooser(MysteryGame game, Item item, GameView frame){
        this.modelGame = game;
        this.modelItem = item;
        this.viewFrame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int slot = modelGame.updateInventory(modelItem);
        viewFrame.updateInventoryPanel(modelItem.getItemName(), slot);
    }
}
