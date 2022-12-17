package org.example.state.game;

import org.example.model.game.window.GameWindow;
import org.example.state.State;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameWindowViewer;
import org.example.controller.Controller;
import org.example.controller.game.GameWindowController;

public class GameState extends State<GameWindow> {
    public GameState(GameWindow gameWindow) {
        super(gameWindow);
    }

    @Override
    protected Viewer<GameWindow> getViewer() {
        return new GameWindowViewer(getModel());
    }

    @Override
    protected Controller<GameWindow> getController() {
        return new GameWindowController(getModel());
    }
}
