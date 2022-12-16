package org.example.controller.game;

import org.example.MainGame;
import org.example.state.menu.MenuState;
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
            if (getModel().collisionImminent(block.getPosition(), "right") || getModel().isPaused()) {
                return;
            }
        }
        getModel().getPlayingShape().pushShapeRight();
    }

    public void  moveShapeLeft() {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "left") || getModel().isPaused()) {
                return;
            }
        }
        getModel().getPlayingShape().pushShapeLeft();
    }

    private void rotateShape() {
        Position originalPosition = new Position(getModel().getPlayingShape().getPosition().getX(), getModel().getPlayingShape().getPosition().getY());
        if (!getModel().isPaused()) {
            getModel().getPlayingShape().rotateShape();
            getModel().getPlayingShape().updateShape();
            rotateShapeCollisionCheck(originalPosition, getModel().getPlayingShape());
        }
    }

    private void rotateShapeCollisionCheck(Position originalPosition, Shape shape) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 5; i++) {
                while (getModel().collisionImminent(shape.getBlocks().get(i).getPosition(), "own")) {
                    if (shape.getBlocks().get(i).getPosition().getY() == 26)
                        shape.pushShapeUp();
                    else if (shape.getBlocks().get(i).getPosition().getX() < shape.getPosition().getX())
                        shape.pushShapeRight();
                    else shape.pushShapeLeft();
                }
            }
        }

        if (abs(originalPosition.getX()-shape.getPosition().getX()) > 2 || shape.getPosition().getX() < 1 || shape.getPosition().getX() > 23) {
            shape.setPosition(originalPosition);
            shape.updateShape();
        }

        for (int i = 0; i < 5; i++) {
            if (getModel().collisionImminent(shape.getBlocks().get(i).getPosition(), "own")) {
                shape.pushShapeUp();
                Position position = new Position(originalPosition.getX(), originalPosition.getY());
                rotateShapeCollisionCheck(position, shape);
                break;
            }
        }
    }

    private boolean pushShapeDown(boolean twice) {
        for (Block block : getModel().getPlayingShape().getBlocks()) {
            if (getModel().collisionImminent(block.getPosition(), "down") || getModel().isPaused()) {
                return true;
            }
        }
        getModel().getPlayingShape().pushShapeDown();
        if (twice) getModel().setScore(getModel().getScore()+2);
        else getModel().setScore(getModel().getScore()+1);
        int previousLevel = getModel().getLevel();
        getModel().setLevel(getModel().getScore()/(5000 + ((500 * ((getModel().getLevel()+5)/5)) * getModel().getLevel())));
        if (getModel().getLevel() < previousLevel) {
            getModel().setLevel(previousLevel);
        }
        return false;
    }

    private void pushShapeFullDown() {
        if (!pushShapeDown(true)) {
            pushShapeFullDown();
        }
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.LEFT) moveShapeLeft();
        if (action == GUI.ACTION.RIGHT) moveShapeRight();
        if (action == GUI.ACTION.ROTATE) rotateShape();
        if (action == GUI.ACTION.DOWN) pushShapeDown(false);
        if (action == GUI.ACTION.FULL_DOWN) pushShapeFullDown();
        if (action == GUI.ACTION.SHAPE_SHIFT && !getModel().getPlayingShape().hasShifted()) {
            getModel().getPlayingShape().shifted();
            rotateShapeCollisionCheck(getModel().getPlayingShape().getPosition(), getModel().getPlayingShape());
        }
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
        if (action == GUI.ACTION.PAUSE && !getModel().isPaused()) getModel().pauseGame();
        else if (action == GUI.ACTION.PAUSE && getModel().isPaused()) getModel().unpauseGame();
    }
}
