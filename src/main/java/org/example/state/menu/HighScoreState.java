package org.example.state.menu;

import org.example.controller.Controller;
import org.example.controller.menu.HighScoreController;
import org.example.model.menu.HighScore;
import org.example.state.State;
import org.example.viewer.Viewer;
import org.example.viewer.menu.HighScoreViewer;

public class HighScoreState extends State<HighScore> {
    public HighScoreState(HighScore model) {
        super(model);
    }

    @Override
    protected Viewer<HighScore> getViewer() {
        return new HighScoreViewer(getModel());
    }

    @Override
    protected Controller<HighScore> getController() {
        return new HighScoreController(getModel());
    }
}
