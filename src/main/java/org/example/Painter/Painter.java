package org.example.Painter;

import org.example.gui.GUI;

import java.io.IOException;

public abstract class Painter<T> {
    private final T model;

    protected Painter(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawEntities(gui);
        gui.refresh();
    }

    public abstract void drawEntities(GUI gui);
}
