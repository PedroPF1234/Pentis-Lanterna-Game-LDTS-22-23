package org.example.gamestate;

import org.example.MainGame;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.window.Window;

import java.io.IOException;

import static java.lang.Math.pow;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    private long timeSinceLastDown = System.currentTimeMillis();

    public State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = getPainter();
    }

    protected abstract Viewer<T> getPainter();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(MainGame game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        if (getModel() instanceof Window && time - timeSinceLastDown > 1000 * pow((1-0.05),((Window) getModel()).getLevel())) {
            timeSinceLastDown = System.currentTimeMillis();
            for (Block block : ((Window) getModel()).getPlayingShape().getBlocks()) {
                if (((Window) getModel()).collisionImminent(block.getPosition(), "down")) {
                    return;
                }
            }
            ((Window) getModel()).getPlayingShape().pushShapeDown();
        }
        viewer.draw(gui);
        if (getModel() instanceof Window && ((Window) getModel()).lostGame) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // E suposto meter gamestate para a pagina de highscore.
            game.setState(new MenuState(new Menu()));
        }
    }

}
