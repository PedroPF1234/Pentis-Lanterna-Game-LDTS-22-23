package org.example.model.game.window;

import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

public class Window {
    private final int width;
    private final int height;

    private Shape shape;

    private Wall wall;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }
}
