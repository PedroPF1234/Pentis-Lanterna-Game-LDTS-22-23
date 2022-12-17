package org.example.state;

import org.example.MainGame;
import org.example.model.game.window.GameWindow;
import org.example.model.menu.HighScore;
import org.example.state.menu.HighScoreState;
import org.example.viewer.Viewer;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;

import java.io.IOException;

import static java.lang.Math.pow;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = this.getViewer();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(MainGame game, GUI gui, long time) throws IOException, InterruptedException {
        GUI.ACTION action = gui.getNextAction();
        viewer.draw(gui);
        controller.step(game, action, time);
    }
}
