package org.example.state.menu;

import org.example.model.menu.HighScore;
import org.example.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class HighScoreStateTest {
    private HighScore highScore;
    private HighScoreState highScoreState;

    @BeforeEach
    void setup() {
        highScore = mock(HighScore.class);
        highScoreState = new HighScoreState(highScore);
    }
    @Test
    void testViewer() {
        assertEquals(highScoreState.getViewer().getModel(), highScore);
    }

    @Test
    void testController() {
        assertEquals(highScoreState.getController().getModel(), highScore);
    }

}