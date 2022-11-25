package org.example.model.game.window;

import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.List;

public abstract class WindowBuilder {
    
    public Window createWindow() {
        Window window = new Window(getWidth(), getHeight());
        
        window.setShape(createShaper());
        window.setWall(createWalls());


        return window;
    }

    protected abstract Shape createShaper();

    protected abstract List<Shape> createShapes();

    protected abstract List<Block> createWalls();

    protected abstract int getWidth();

    protected abstract int getHeight();

    //Create Walls
}
