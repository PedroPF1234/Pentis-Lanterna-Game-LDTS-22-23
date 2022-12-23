package org.example.state.menu;

import org.example.gui.LanternaGUI;
import org.example.model.menu.Menu;
import org.example.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MenuStateTest {

    private Menu menu;
    private MenuState menuState;

    @BeforeEach
    void setup() {
        menu = new Menu();
        menuState = new MenuState(menu);
    }
    @Test
    void testViewer() {
        assertEquals(menuState.getViewer().getModel(), menu);
    }

    @Test
    void testController() {
        assertEquals(menuState.getController().getModel(), menu);
    }
}