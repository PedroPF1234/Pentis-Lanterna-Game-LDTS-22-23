package org.example.state.game;

import org.example.model.game.window.GameWindow;
import org.example.model.game.window.GameWindowBuilderLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    private GameWindow gameWindow;
    private GameState gameState;

    @BeforeEach
    void setup() {
        gameWindow = new GameWindowBuilderLoader().createWindow();
        gameState = new GameState(gameWindow);
    }
    @Test
    void getViewer() {
        assertEquals(gameState.getViewer().getModel(), gameWindow);
    }

    @Test
    void getController() {
        assertEquals(gameState.getController().getModel(), gameWindow);
    }
}