package org.example.model.game.window;

import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.List;

public abstract class GameWindowBuilder {
    
    public GameWindow createWindow() {
        GameWindow gameWindow = new GameWindow(getWidth(), getHeight());

        gameWindow.setShapes(createShapes());
        gameWindow.setWall(createWalls());


        return gameWindow;
    }

    protected abstract List<Shape> createShapes();

    protected abstract List<Wall> createWalls();

    protected abstract int getWidth();

    protected abstract int getHeight();
}
