package org.example.controller.menu;

import org.example.MainGame;
import org.example.controller.Controller;
import org.example.model.menu.HighScore;
import org.example.model.menu.Instructions;
import org.example.state.game.GameState;
import org.example.gui.GUI;

import org.example.model.game.window.GameWindowBuilderLoader;
import org.example.model.menu.Menu;
import org.example.state.menu.HighScoreState;
import org.example.state.menu.InstructionsState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {


    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case ROTATE:
                getModel().previousSelections();
                break;
            case DOWN:
                getModel().nextSelection();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new GameWindowBuilderLoader().createWindow()));
                if (getModel().isSelectedHighscore()) game.setState(new HighScoreState(new HighScore(0, 0, false)));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Instructions()));
        }
    }
}
