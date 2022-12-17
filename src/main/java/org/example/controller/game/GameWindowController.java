package org.example.controller.game;

import org.example.MainGame;
import org.example.model.game.window.GameWindow;
import org.example.state.menu.MenuState;
import org.example.gui.GUI;
import org.example.model.menu.Menu;

import java.io.IOException;

public class GameWindowController extends GameController {

    private final ShapeController shapeController;

    public GameWindowController(GameWindow gameWindow) {
        super(gameWindow);

        this.shapeController = new ShapeController(gameWindow);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            shapeController.step(game, action, time);
        }
    }
}
