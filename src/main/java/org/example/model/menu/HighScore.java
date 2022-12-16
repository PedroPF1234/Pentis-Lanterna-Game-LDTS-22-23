package org.example.model.menu;


import java.util.ArrayList;
import java.util.List;

public class HighScore {

     private boolean fromGameOver;
     private int score, level;
     private List<Character> name = new ArrayList<>();


     //The constructor
     public HighScore(int score, int level, boolean fromGameOver) {
        this.score = score;
        this.level = level;
        this.fromGameOver = fromGameOver;
        this.name.add(' ');
        this.name.add(' ');
        this.name.add(' ');
     }

     //The setters and getters
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


     public List<Character> getName() {
         return name;
     }

     public boolean isFromGameOver() {
         return fromGameOver;
     }

     public void userPromptFinished() {
         this.fromGameOver = false;
     }

     /*
     //Decides whether this HighScore is greater than, less than, or equal to the argument
     public int compareTo(HighScore h) {
        // return new Integer(this.score).compareTo(h.score);
         return 0;
     }

     private static void initializeHighscores() {
         HighScore[] h = {new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                 new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                 new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                 new HighScore(0, 0, "...")};
     }

     public static HighScore[] getHighScores() {
         return new HighScore[0];
     }


     public static void addHighScore(HighScore h) {
         HighScore[] highScores = getHighScores();
         highScores[highScores.length - 1] = h;
         for (int i = highScores.length - 2; i >= 0; i--) {
             if (highScores[i + 1].compareTo(highScores[i]) > 0) {
                 HighScore temp = highScores[i];
                 highScores[i] = highScores[i + 1];
                 highScores[i + 1] = temp;
             }
         }
     }
     */
 }

