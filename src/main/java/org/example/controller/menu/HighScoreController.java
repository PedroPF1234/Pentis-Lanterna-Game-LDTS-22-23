package org.example.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.example.MainGame;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.HighScore;
import org.example.model.menu.Menu;
import org.example.state.menu.MenuState;

import java.io.IOException;

public class HighScoreController extends Controller<HighScore> {
    public HighScoreController(HighScore model) {
        super(model);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException, InterruptedException {
        if (getModel().isFromGameOver()) {
            game.getGui().clear();
            while (true) {
                //game.getState().getViewer().draw(game.getGui());
                game.getState().getViewer().drawEntities(game.getGui());
                game.getGui().refresh();
                KeyStroke keyStroke = game.getGui().getScreen().pollInput();
                if (keyStroke == null) continue;
                if (keyStroke.getKeyType() == KeyType.Character) {
                    for (int i = 0; i < getModel().getName().size(); i++) {
                        if (getModel().getName().get(i) == ' ') {
                            getModel().getName().set(i, keyStroke.getCharacter());
                            break;
                        }
                    }
                }
                if (keyStroke.getKeyType() ==  KeyType.Backspace) {
                    for (int i = getModel().getName().size() - 1; i >= 0; i--) {
                        if (getModel().getName().get(i) != ' ') {
                            getModel().getName().set(i, ' ');
                            break;
                        }
                    }
                }
                if (keyStroke.getKeyType() == KeyType.Escape) {
                    game.setState(new MenuState(new Menu()));
                    break;
                }
                if (keyStroke.getKeyType() == KeyType.Enter) {
                    getModel().userPromptFinished();
                    //Method call to add to file of highscores.
                    break;
                }
                Thread.sleep(1000/game.getFPS());
            }
        }
        else {
            if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
        }
    }
}
