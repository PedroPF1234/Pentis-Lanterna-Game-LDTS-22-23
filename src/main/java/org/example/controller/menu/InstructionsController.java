package org.example.controller.menu;

import org.example.MainGame;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.example.state.menu.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions model) {
        super(model);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException, InterruptedException {
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
    }
}
