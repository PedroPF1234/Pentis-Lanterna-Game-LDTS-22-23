package org.example.controller;

import org.example.MainGame;
import org.example.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {

    private final T model;

    public Controller(T model) {
        this.model = model;
    }


    public T getModel() {
        return model;
    }

    public abstract void step(MainGame game, GUI.ACTION action, long time) throws IOException, InterruptedException;
}
