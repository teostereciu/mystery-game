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
        //System.out.println("You clicked an inventory item!");
        if (result == 0) {
            //System.out.println("You chose to drop it!");
            if (modelItem.getRoomNumber() == modelGame.getCurrentRoomNum()) {
                //System.out.println("Item was dropped!");
                modelGame.updateInventory(modelItem, 0);
            } else {
                //System.out.println("You could not be dropped!");
                viewFrame.displayDialog(0);
            }
        } else {
            switch(modelItem.getItemName()){
                case "hat":
                    modelGame.increaseNPCProgress(1);
                    modelGame.increaseNPCProgress(0);
                    modelGame.getRoom(3).setIsOpen(true);
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "euro":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    modelGame.increaseNPCProgress(0);
                    modelGame.increaseNPCProgress(1);
                    modelGame.getRoom(5).setIsOpen(true);
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "phone":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    modelGame.increaseNPCProgress(0);
                    modelGame.increaseNPCProgress(1);
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "coffee":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    modelGame.getRoom(4).setIsOpen(true);
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "cleaning-supplies":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    //get access to safe
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "flashlight":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    modelGame.increaseNPCProgress(1);
                    modelGame.increaseNPCProgress(5);
                    //light up melvin's room
                    modelGame.setFlashlightIsOn(!modelGame.getFlashlightIsOn());
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "Video Tape":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        System.out.println("to soon");
                        break;
                    }
                    //new dialogue
                    modelGame.updateInventory(modelItem, 2);
                    break;
                case "hammer":
                    if (modelGame.checkIfPlayable(modelItem) == 0){
                        //todo print "this item cannot be played yet" or something
                        break;
                    }
                    //break desk lock
                    modelGame.updateInventory(modelItem, 2);
                    break;
            }
            viewFrame.displayDialog(5);
            // USE ITEM; // todo csanad
        }
    }
}