package org.example.model.menu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighScore {

     private boolean fromGameOver;
     private int score, level;
     private char[] name = {'a', 'a', 'a'};

    private final List<Integer> selections = Arrays.asList(0, 1, 2);

    private int currentSelection = 0;


     //The constructor
     public HighScore(int score, int level, boolean fromGameOver) {
        this.score = score;
        this.level = level;
        this.fromGameOver = fromGameOver;
     }

     public void setScore(int score) {
         this.score = score;
     }

     public int getScore() {
         return score;
     }

     public void setLevel(int level) {
         this.level = level;
     }

     public int getLevel() {
         return level;
     }


     public char[] getName() {
         return name;
     }

     public boolean isFromGameOver() {
         return fromGameOver;
     }

     public void userPromptFinished() {
         this.fromGameOver = false;
     }

    public int getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(int currentSelection) {
        this.currentSelection = currentSelection;
    }
}

