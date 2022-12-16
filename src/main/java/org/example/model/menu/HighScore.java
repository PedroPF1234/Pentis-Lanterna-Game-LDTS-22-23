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

     public String nameToString() {
         boolean isNotNull = false;
         char[] newName = new char[3];
         for (int i = 0; i < 3; i++) {
             if (name.get(i) != ' ') isNotNull = true;
         }

         if (isNotNull) {
             for (int i = 0; i < 3; i++) {
                 newName[i] = name.get(i);
             }
         }
         else newName = new char[]{'#', '#', '#'};
         return newName.toString();
    }
 }

