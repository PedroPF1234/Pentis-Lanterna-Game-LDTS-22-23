package org.example.model.game.window;

import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;

import java.util.List;

public abstract class GameWindowBuilder {
    
    public GameWindow createWindow() {
        GameWindow gameWindow = new GameWindow(getWidth(), getHeight());

        gameWindow.setShapes(createShapes());
        gameWindow.setWall(createWalls());


        return gameWindow;
    }

    protected abstract List<Shape> createShapes();

    protected abstract List<Block> createWalls();

    protected abstract int getWidth();

    protected abstract int getHeight();
}
