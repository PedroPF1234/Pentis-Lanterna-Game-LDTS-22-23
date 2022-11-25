package org.example.controller.game;

import org.example.MainGame;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.window.Window;

import java.io.IOException;

public abstract class GameController extends Controller<Window> {
    public GameController(Window model) {
        super(model);
    }
}
