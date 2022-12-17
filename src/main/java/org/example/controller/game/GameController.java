package org.example.controller.game;

import org.example.controller.Controller;
import org.example.model.game.window.GameWindow;

public abstract class GameController extends Controller<GameWindow> {
    public GameController(GameWindow model) {
        super(model);
    }

}
