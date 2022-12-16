package org.example.model.menu.Score;

import java.io.Serializable;

public class Score implements Serializable {
    private int level;
    private int score;
    private String name;
    public Score(int level, int score, String name) {
        this.level = level;
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
