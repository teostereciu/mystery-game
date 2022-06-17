package nl.ai.rug.oop.rpg.controller;
import nl.ai.rug.oop.rpg.model.Item;
import nl.ai.rug.oop.rpg.model.MysteryGame;
import nl.ai.rug.oop.rpg.view.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Controller class for choosing/picking up an item.
 * @author veghcsanad
 */
public class ItemChooser implements ActionListener {
    private MysteryGame modelGame;
    private GameView viewFrame;
    private Item modelItem;

    /**
     * Constructor of the ItemChooser class.
     * @param game
     * @param item
     * @param frame
     */
    public ItemChooser(MysteryGame game, Item item, GameView frame){
        this.modelGame = game;
        this.modelItem = item;
        this.viewFrame = frame;
    }

    /**
     * Called when an item is clicked. Different functionalities for different types of items.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int outcome;
        if (modelItem.getIsCarryAble() == 0) {
            outcome = modelGame.updateProgress(modelItem);
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
                    modelGame.updateProgress(modelItem);
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
                }
            }
        } else {
            outcome = modelGame.updateInventory(modelItem, 1);
            if (outcome == 0) {
                viewFrame.displayDetectiveWarnings(2);
            }
        }
    }
}
