package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.HighScore;
import org.example.viewer.Viewer;

import java.io.IOException;


public class HighScoreViewer extends Viewer<HighScore> {
    public HighScoreViewer(HighScore model) {
        super(model);
    }

    @Override
    public void drawEntities(GUI gui) throws IOException {
        if (getModel().isFromGameOver()) {
            drawUserPrompt(gui);
        }
        else {
            drawsHighscoreTable(gui);
        }
    }

    private void drawUserPrompt(GUI gui) throws IOException {
        gui.drawText(new Position(2, 4), "Game Over! It's time to save your score.", "#FFFFFF");
        gui.drawText(new Position(2, 8), "Press ESC if you wish to exit without saving.", "#FFFFFF");
        gui.drawText(new Position(2, 12), "Once you're done, press Enter", "#FFFFFF");
        for (int i = 0; i < getModel().getName().size(); i++) {
            gui.drawText(new Position(10 + i, 16), String.valueOf(getModel().getName().get(i)), "#FFFFFF");
        }
    }

    private void drawsHighscoreTable(GUI gui) throws IOException {
        gui.drawText(new Position(2, 2), "Here are the top 10 players!", "#FFFFFF");
    }
}
