package nl.ai.rug.oop.rpg.controller;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
        int outcome = modelGame.updateProgress(modelItem); // PROGRESS GAMEPLAY

        if (modelItem.getIsCarryAble() == 0) { // PICKUP/CLOSEUP
            // use item
            //if(modelItem.getIsPlayable()==1) {
            if (outcome == 2) {
                viewFrame.displayDialog(7);
                return;
            }

                if (Objects.equals(modelItem.getItemName(), "phone")) {
                    modelGame.updateInventory(modelItem, 1);
                    viewFrame.closeUp(modelItem);
                }
                if (Objects.equals(modelItem.getItemName(), "computer")) {
                    viewFrame.closeUp(modelItem);
                }
            //}
        } else { //PICKUP
            outcome = modelGame.updateInventory(modelItem, 1);
            if (outcome == 0) {
                viewFrame.displayDialog(2); // note we can stick to only using the property change by having an error variable in the model (set to 2 by this event for eg)
            }
        }
    }
}
