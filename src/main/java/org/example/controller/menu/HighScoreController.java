package org.example.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.example.MainGame;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.HighScore;
import org.example.model.menu.Menu;
import org.example.model.menu.Score.Score;
import org.example.model.menu.Score.ScoreList;
import org.example.model.menu.Score.ScoreWriter;
import org.example.state.menu.MenuState;

import java.io.File;
import java.io.IOException;

public class HighScoreController extends Controller<HighScore> {
    public HighScoreController(HighScore model) {
        super(model);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException, InterruptedException {
        if (getModel().isFromGameOver()) {

            if (action == GUI.ACTION.DOWN) {
                char temp = getModel().getName()[getModel().getCurrentSelection()];
                if (getModel().getName()[getModel().getCurrentSelection()] == 'z') {
                    getModel().getName()[getModel().getCurrentSelection()] = 'A';
                }
                else if (getModel().getName()[getModel().getCurrentSelection()] == 'Z') {
                    getModel().getName()[getModel().getCurrentSelection()] = '0';
                }
                else if (getModel().getName()[getModel().getCurrentSelection()] == '9') {
                    getModel().getName()[getModel().getCurrentSelection()] = 'a';
                }
                else  {
                    temp++;
                    getModel().getName()[getModel().getCurrentSelection()] = temp;
                }
            } //Passar a letra
            if (action == GUI.ACTION.ROTATE) {
                char temp = getModel().getName()[getModel().getCurrentSelection()];
                if (getModel().getName()[getModel().getCurrentSelection()] == 'A') {
                    getModel().getName()[getModel().getCurrentSelection()] = 'z';
                }
                else if (getModel().getName()[getModel().getCurrentSelection()] == '0') {
                    getModel().getName()[getModel().getCurrentSelection()] = 'Z';
                }
                else if (getModel().getName()[getModel().getCurrentSelection()] == 'a') {
                    getModel().getName()[getModel().getCurrentSelection()] = '9';
                }
                else  {
                    temp--;
                    getModel().getName()[getModel().getCurrentSelection()] = temp;
                }
            }
            if (action == GUI.ACTION.LEFT) {
                if (getModel().getCurrentSelection() == 0) {
                    getModel().setCurrentSelection(getModel().getCurrentSelection() + 3);
                }
                getModel().setCurrentSelection(getModel().getCurrentSelection() - 1);
            }
            if (action == GUI.ACTION.RIGHT) {
                if (getModel().getCurrentSelection() == 2) {
                    getModel().setCurrentSelection(getModel().getCurrentSelection() - 3);
                }
                getModel().setCurrentSelection(getModel().getCurrentSelection() + 1);
            }

            if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
            if (action == GUI.ACTION.SELECT) {
                getModel().userPromptFinished();
                Score score = new Score(getModel().getLevel(), getModel().getScore(), getModel().getName());
                ScoreList scoreList = new ScoreList();
                scoreList.addScore(score);
                ScoreWriter scoreWriter = new ScoreWriter();
                scoreWriter.writeInFile(scoreList);
            }
        }
        else {
            if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
            if (action == GUI.ACTION.DELETE) {
                File file = new File("src/main/resources/highscores/scores.txt");
                file.delete();
            }
        }
    }
}
