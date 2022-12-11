package org.example.controller.game;

import org.example.MainGame;
import org.example.gamestate.MenuState;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.window.Window;
import org.example.model.menu.Menu;

import java.io.IOException;

public class ShapeController extends GameController{
    public ShapeController(Window window) {
        super(window);
    }

    public void moveShapeRight() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "right")) {
                return;
            }
        }
        getModel().getPlayingShape().pushShapeRight();
    }

    public void  moveShapeLeft() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "left")) {
                return;
            }
        }
        getModel().getPlayingShape().pushShapeLeft();
    }

    private void rotateShape() {
        getModel().getPlayingShape().rotateShape();
        getModel().getPlayingShape().updateShape();
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                int tries = 0;
                while (getModel().collisionImminent(getModel().getPlayingShape().getBlocks().get(i).getPosition(), "own") && tries < 3) {
                    if (getModel().getPlayingShape().getBlocks().get(i).getPosition().getY() == 26) getModel().getPlayingShape().pushShapeUp();
                    else if (getModel().getPlayingShape().getBlocks().get(i).getPosition().getX() < 15) getModel().getPlayingShape().pushShapeRight();
                    else getModel().getPlayingShape().pushShapeLeft();
                    tries++;
                }
            }
        }
    }

    private void pushShapeDown() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "down")) {
                return;
            }
        }
        getModel().getPlayingShape().pushShapeDown();
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveShapeLeft();
        if (action == GUI.ACTION.RIGHT) moveShapeRight();
        if (action == GUI.ACTION.ROTATE) rotateShape();
        if (action == GUI.ACTION.FULL_DOWN) pushShapeDown();
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
    }
}
