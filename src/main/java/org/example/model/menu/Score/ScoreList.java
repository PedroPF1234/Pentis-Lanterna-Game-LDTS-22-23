package org.example.model.menu.Score;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreList implements Serializable {
    private List<Score> scores = new ArrayList<>();

    public ScoreList() {
        loadScores();
    }

    public void addScore(Score score) {
        scores.add(score);
        sortScores();
    }

    public List<Score> getScores() {
        return scores;
    }

    public void  loadScores() {
        try {
            scores = new ScoreReader().read().getScores();
        } catch (Exception ignored) {
        }
    }

    private void sortScores() {
        scores = scores.stream().sorted(Comparator.comparing(Score::getScore, Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
