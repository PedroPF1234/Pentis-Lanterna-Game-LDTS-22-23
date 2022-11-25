package org.example.model.menu;


public class HighScore {

    private int score, level;
    private String name;

        //The constructor
        public HighScore(int s, int l, String n){
            score=s;
            setLevel(l);
            setName(n);
        }

        //The setters and getters
        public void setScore(int score) {
            this.score=score;
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

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        //Decides whether this HighScore is greater than, less than, or equal to the argument
        public int compareTo(HighScore h) {
            return new Integer(this.score).compareTo(h.score);
        }

    private static void initializeHighscores() {
        HighScore[] h = {new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                new HighScore(0, 0, "..."), new HighScore(0, 0, "..."), new HighScore(0, 0, "..."),
                new HighScore(0, 0, "...")};
        }

    public static HighScore[] getHighScores() {
        }


    public static void addHighScore(HighScore h)
    {
        HighScore[] highScores=getHighScores();
        highScores[highScores.length-1]=h;
        for (int i=highScores.length-2; i>=0; i--)
        {
            if (highScores[i+1].compareTo(highScores[i])>0)
            {
                HighScore temp=highScores[i];
                highScores[i]=highScores[i+1];
                highScores[i+1]=temp;
            }
        }

