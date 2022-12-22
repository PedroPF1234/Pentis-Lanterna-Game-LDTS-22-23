package org.example.model.game.window;

import org.example.model.game.entities.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GameWindowTest {
    @Test
    void testDefaults() {
        GameWindow gameWindow = mock(GameWindow.class);
        assertEquals(0, gameWindow.getLevel());
        assertEquals(0, gameWindow.getScore());
        assertEquals(0, gameWindow.getWidth());
        assertEquals(0, gameWindow.getHeight());
        assertFalse(gameWindow.isPaused());
    }

    @Test
    void testPlayingShapeVariation() {
        GameWindow gameWindow = new GameWindow(50, 50);
        assertNull(gameWindow.getShapes());
        List<Shape> list = new ArrayList<>();
        list.add(new Shape(5, 5));
        list.add(new Shape(6, 6));
        list.add(new Shape(7, 7));
        gameWindow.setShapes(list);
        assertEquals(gameWindow.getPlayingShape(), list.get(0));
        list.add(new Shape(8, 8));
        list.add(new Shape(9, 9));
        assertEquals(gameWindow.getPlayingShape(), list.get(2));
        for (int i = 0; i < 100; i++) {
            list.add(new Shape(5,5));
            assertEquals(gameWindow.getPlayingShape(), list.get(3+i));
        }
    }
}