package org.example.controller.game;

import org.example.MainGame;
import org.example.gamestate.MenuState;
import org.example.gui.GUI;
import org.example.model.game.window.Window;
import org.example.model.menu.Menu;

import java.io.IOException;

public class WindowController extends GameController{

    private final ShapeController shapeController;

    public WindowController(Window window) {
        super(window);

        //set up shape controller.
        this.shapeController = new ShapeController(window);
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
