package org.example.viewer;

import org.example.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    protected Viewer(T model) {
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

    public abstract void drawEntities(GUI gui) throws IOException;
}
