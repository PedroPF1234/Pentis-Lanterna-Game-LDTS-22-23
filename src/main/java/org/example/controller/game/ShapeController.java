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
        getModel().getPlayingShape().setPosition(getModel().getPlayingShape().getPosition().getRight());
        getModel().getPlayingShape().updateShape();
    }

    public void  moveShapeLeft() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "left")) {
                return;
            }
        }
        getModel().getPlayingShape().setPosition(getModel().getPlayingShape().getPosition().getLeft());
        getModel().getPlayingShape().updateShape();
    }

    private void rotateShape() {
    }

    private void fullDownShape() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "down")) {
                return;
            }
        }
        getModel().getPlayingShape().downShape();
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveShapeLeft();
        if (action == GUI.ACTION.RIGHT) moveShapeRight();
        if (action == GUI.ACTION.ROTATE) rotateShape();
        if (action == GUI.ACTION.FULL_DOWN) fullDownShape();
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
    }
}
