package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.HighScore;
import org.example.model.menu.Score.Score;
import org.example.model.menu.Score.ScoreList;
import org.example.model.menu.Score.ScoreReader;
import org.example.viewer.Viewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


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
            try {
                drawsHighscoreTable(gui);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void drawUserPrompt(GUI gui) throws IOException {
        gui.drawText(new Position(2, 4), "game over! it's time to save your score.", "#FFFFFF");
        gui.drawText(new Position(2, 8), "press esc if you wish to exit without saving.", "#FFFFFF");
        gui.drawText(new Position(2, 12), "once you're done, press enter", "#FFFFFF");
        gui.drawText(new Position(2, 16), "your tag: ", "#FFFFFF");
        for (int i = 0; i < getModel().getName().length; i++) {
            if (getModel().getCurrentSelection() == i) {
                gui.drawTextChar(new Position(12 + i, 16), getModel().getName()[i], "#FFD700");
            }
            else gui.drawTextChar(new Position(12 + i, 16), getModel().getName()[i], "#FFFFFF");
        }
    }

    private void drawsHighscoreTable(GUI gui) throws IOException, ClassNotFoundException {
        ScoreList scoreList = new ScoreList();
        List<Score> scores = scoreList.getScores();
        if (scores.size() != 0) {
            gui.drawText(new Position(2, 2), "here are the top " + scores.size() + " players!", "#FFFFFF");
            gui.drawText(new Position(2, 25), "press d to delete the highscores table.", "#FFFFFF");
        }
        else {
            gui.drawText(new Position(2, 2), "no scores were found.", "#FFFFFF");
            gui.drawText(new Position(2, 4), "go play and set a new highscore!", "#FFFFFF");
        }
        for (int i = 0; i < scores.size(); i++) {
            char[] temp = scores.get(i).getName();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = temp.length - 1; j >= 0; j--) {
                stringBuilder.insert(0, temp[j]);
            }
            if (i == 0) {
                gui .drawText(new Position(2, 4), "1st:", "#00FF00");
                gui.drawText(new Position(7, 4),
                        stringBuilder + ", score:  " + scores.get(i).getScore()
                        + ", level: " + (scores.get(i).getLevel()+1), "#FFFFFF");
            }
            else if (i == 1) {
                gui .drawText(new Position(2, 6), "2nd:", "#FFFF00");
                gui.drawText(new Position(7, 6),
                        stringBuilder + ", score:  " + scores.get(i).getScore()
                                + ", level: " + (scores.get(i).getLevel()+1), "#FFFFFF");
            }
             else if (i == 2) {
                gui .drawText(new Position(2, 8), "3rd:", "#FF0000");
                gui.drawText(new Position(7, 8),
                        stringBuilder + ", Score:  " + scores.get(i).getScore()
                                + ", Level: " + (scores.get(i).getLevel()+1), "#FFFFFF");
            }
             else {
                gui .drawText(new Position(2, 4 + 2*i), (i+1) + "th:", "#FFFFFF");
                gui.drawText(new Position(7, 4 + 2*i),
                        stringBuilder + ", score:  " + scores.get(i).getScore()
                                + ", level: " + (scores.get(i).getLevel()+1), "#FFFFFF");
            }
        }
    }
}
