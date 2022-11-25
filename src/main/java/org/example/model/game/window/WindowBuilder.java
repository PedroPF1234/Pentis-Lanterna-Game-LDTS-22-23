package org.example.model.game.window;

import org.example.model.game.entities.Shape;

public abstract class WindowBuilder {
    
    public Window createWindow() {
        Window window = new Window(getWidth(), getHeight());
        
        window.setShape(createShaper());
        //Set Walls of Window


        return window;
    }

    protected abstract Shape createShaper();

    protected abstract int getWidth();

    protected abstract int getHeight();

    //Create Walls
}
