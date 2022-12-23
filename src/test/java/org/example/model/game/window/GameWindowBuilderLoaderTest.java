package org.example.model.game.window;

import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameWindowBuilderLoaderTest {
    private GameWindow gameWindow;

    @BeforeEach
    void setup() {
        GameWindowBuilderLoader gameWindowBuilderLoader = new GameWindowBuilderLoader();
        gameWindow = gameWindowBuilderLoader.createWindow();
    }

    @Test
    void testCreateWindow() {
        assertEquals(27 ,gameWindow.getHeight());
        assertEquals(50 ,gameWindow.getWidth());
        assertEquals(3, gameWindow.getShapes().size());
        assertEquals(78, gameWindow.getWalls().size());
    }

    @Test
    void testInitialShapePositions() {
        assertTrue(new Position(6,4).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-3).getPosition()));
        assertTrue(new Position(23,5).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-2).getPosition()));
        assertTrue(new Position(23,11).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-1).getPosition()));
    }
}