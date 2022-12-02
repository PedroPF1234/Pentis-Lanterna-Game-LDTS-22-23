package org.example.controller.game;

import org.example.MainGame;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.window.Window;

import java.io.IOException;

public class ShapeController extends GameController{
    public ShapeController(Window window) {
        super(window);
    }

    public void moveShapeRight() {
        //if statement to check if the shape is going to hit a window wall or not
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            block.setPosition(block.getPosition().getRight());
        }
    }

    public void  moveShapeLeft() {
        //if statement to check if the shape is going to hit a window wall or not
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            block.setPosition(block.getPosition().getLeft());
        }
    }

    private void rotateShape() {
    }

    private void fullDownShape() {
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveShapeLeft();
        if (action == GUI.ACTION.RIGHT) moveShapeRight();
        if (action == GUI.ACTION.ROTATE) rotateShape();
        if (action == GUI.ACTION.FULL_DOWN) fullDownShape();
    }
}
