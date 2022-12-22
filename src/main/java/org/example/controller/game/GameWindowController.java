package org.example.controller.game;

import org.example.MainGame;
import org.example.model.game.entities.Block;
import org.example.model.game.window.GameWindow;
import org.example.model.menu.HighScore;
import org.example.state.menu.HighScoreState;
import org.example.state.menu.MenuState;
import org.example.gui.GUI;
import org.example.model.menu.Menu;

import java.io.IOException;

import static java.lang.Math.pow;

public class GameWindowController extends GameController {

    private final ShapeController shapeController;

    private long timeSinceLastDown = System.currentTimeMillis();

    public GameWindowController(GameWindow gameWindow) {
        super(gameWindow);

        this.shapeController = new ShapeController(gameWindow);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            if (getModel().lostGame) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                game.setState(new HighScoreState(new HighScore(getModel().getScore(), getModel().getLevel(), true)));
            }
            if (time - timeSinceLastDown > 1000 * pow((0.90), getModel().getLevel()) && !getModel().isPaused()) {
                timeSinceLastDown = System.currentTimeMillis();
                for (Block block :getModel().getPlayingShape().getBlocks()) {
                    if (getModel().collisionImminent(block.getPosition(), "down")) {
                        return;
                    }
                }
                getModel().getPlayingShape().pushShapeDown();
            }
            shapeController.step(game, action, time);
        }
    }
}
