package org.example.model.game.window;

import org.example.model.game.entities.Shape;

public class WindowBuilderLoader extends WindowBuilder{
    @Override
    protected Shape createShaper() {
        return new Shape(5, 5);

    }

    @Override
    protected int getWidth() {
        return 100;
    }

    @Override
    protected int getHeight() {
        return 100;
    }
}
