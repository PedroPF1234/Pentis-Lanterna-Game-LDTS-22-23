package org.example.model.menu.Score;

import java.io.Serializable;

public class Score implements Serializable {
    private int level;
    private int score;
    private char[] name;
    public Score(int level, int score, char[] name) {
        this.level = level;
        this.score = score;
        this.name = name;
    }

    public char[] getName() {
        return name;
    }

    public void setName(char[] name) {
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
