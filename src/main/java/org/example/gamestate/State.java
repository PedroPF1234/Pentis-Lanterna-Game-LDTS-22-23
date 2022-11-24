package org.example.gamestate;

import org.example.MainGame;
import org.example.Painter.Painter;
import org.example.controller.Controller;
import org.example.gui.GUI;

import java.io.IOException;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;
    private final Painter<T> painter;

    public State(T model) {
        this.model = model;
        this.controller = getController();
        this.painter = getPainter();
    }

    protected abstract Painter<T> getPainter();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(MainGame game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        painter.draw(gui);
    }

}
