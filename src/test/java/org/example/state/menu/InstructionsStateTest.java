package org.example.state.menu;

import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionsStateTest {

    private Instructions instructions;
    private InstructionsState instructionsState;

    @BeforeEach
    void setup() {
        instructions = new Instructions();
        instructionsState = new InstructionsState(instructions);
    }
    @Test
    void testViewer() {
        assertEquals(instructionsState.getViewer().getModel(), instructions);
    }

    @Test
    void testController() {
        assertEquals(instructionsState.getController().getModel(), instructions);
    }

}