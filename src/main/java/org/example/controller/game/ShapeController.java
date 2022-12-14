package org.example.controller.game;

import org.example.MainGame;
import org.example.gamestate.MenuState;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.window.Window;
import org.example.model.menu.Menu;

import java.io.IOException;

import static java.lang.Math.abs;

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
        Position originalPosition = new Position(getModel().getPlayingShape().getPosition().getX(), getModel().getPlayingShape().getPosition().getY());
        getModel().getPlayingShape().rotateShape();
        getModel().getPlayingShape().updateShape();
        rotateShapeCollision(originalPosition, getModel().getPlayingShape());
    }

    private void rotateShapeCollision(Position originalPosition, Shape shape) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                while (getModel().collisionImminent(shape.getBlocks().get(i).getPosition(), "own")) {
                    if (shape.getBlocks().get(i).getPosition().getY() == 26)
                        shape.pushShapeUp();
                    else if (shape.getBlocks().get(i).getPosition().getX() < shape.getPosition().getX())
                        shape.pushShapeRight();
                    else shape.pushShapeLeft();
                }
            }
            if (abs(originalPosition.getX()-shape.getPosition().getX()) > 4) {
                shape.setPosition(originalPosition);
                shape.updateShape();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (getModel().collisionImminent(shape.getBlocks().get(i).getPosition(), "own")) {
                shape.pushShapeUp();
                Position position = new Position(originalPosition.getX(), originalPosition.getY());
                rotateShapeCollision(position, shape);
                break;
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
