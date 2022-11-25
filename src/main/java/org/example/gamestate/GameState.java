package org.example.gamestate;

import org.example.Painter.Painter;
import org.example.Painter.game.GamePainter;
import org.example.controller.Controller;
import org.example.model.game.window.Window;

public class GameState extends State<Window> {
    public GameState(Window window) {
        super(window);
    }

    @Override
    protected Painter<Window> getPainter() {
        return new GamePainter(getModel());
    }

    @Override
    protected Controller<Window> getController() {
        return null;
    }
}
