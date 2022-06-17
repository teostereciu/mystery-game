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
        int outcome;
        if (modelItem.getIsCarryAble() == 0) { // PICKUP/CLOSEUP
            // use item
            outcome = modelGame.updateProgress(modelItem); // PROGRESS GAMEPLAY
            //if(modelItem.getIsPlayable()==1) {
            if (outcome == 2 && !Objects.equals(modelItem.getItemName(), "safe")) {
                viewFrame.displayDetectiveWarnings(7);
                return;
            }

            if (Objects.equals(modelItem.getItemName(), "phone")) {
                modelGame.updateInventory(modelItem, 1);
                viewFrame.closeUp(modelItem);
            }
            if (Objects.equals(modelItem.getItemName(), "computer")) {
                viewFrame.closeUp(modelItem);
            }
            if (Objects.equals(modelItem.getItemName(), "safe")) {
                String answer = viewFrame.displayInsertSafeCodeDialog();
                if (Objects.equals(answer, "420")) {
                    modelGame.setCodeHasBeenCracked(true);
                    modelGame.updateProgress(modelItem); //not using this function gave problems
                    viewFrame.displaySafeDialog(true);
                    modelGame.accessItems.get(15).setIsAvailable(1);
                    viewFrame.updateRoom();
                } else {
                    viewFrame.displaySafeDialog(false);
                }
            }
            if (Objects.equals(modelItem.getItemName(), "crate")) {
                if (modelItem.getIsPlayable() == 1) {
                    viewFrame.displayDetectiveWarnings(8);
                    //viewFrame.displayEnding(); idk when to do this. should be after stacey last dialogue

                }
            }
            //}
        } else { //PICKUP
            outcome = modelGame.updateInventory(modelItem, 1);
            if (outcome == 0) {
                viewFrame.displayDetectiveWarnings(2);
            }
        }
    }
}
