package org.example.state.game;

import org.example.state.State;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;
import org.example.controller.Controller;
import org.example.controller.game.WindowController;
import org.example.model.game.window.Window;

public class GameState extends State<Window> {
    public GameState(Window window) {
        super(window);
    }

    @Override
    protected Viewer<Window> getPainter() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Window> getController() {
        return new WindowController(getModel());
    }
}
