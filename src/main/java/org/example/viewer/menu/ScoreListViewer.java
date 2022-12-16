package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Score.ScoreList;
import org.example.viewer.Viewer;

import java.io.IOException;

public class ScoreListViewer extends Viewer<ScoreList> {
    protected ScoreListViewer(ScoreList model) {
        super(model);
    }

    @Override
    public void drawEntities(GUI gui) throws IOException {
        for (int i = 0; i < getModel().getScores().size(); i++) {
            String toOutput = getModel().getScores().get(i).getName() + " " + getModel().getScores().get(i).getScore();
            gui.drawText(new Position(2, 4 + 2*i), toOutput, "#FFFFFF");
        }
    }
}
