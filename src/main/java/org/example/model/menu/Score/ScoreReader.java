package org.example.model.menu.Score;

import java.io.*;

public class ScoreReader {
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    public ScoreReader() throws IOException {
        File score = new File("src/main/resources/highscores/scores.txt");

        if (score.createNewFile()) {
            FileOutputStream fileOutputStream = new FileOutputStream(score);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new ScoreList());
        }
        fileInputStream = new FileInputStream(score);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public ScoreList read() throws IOException, ClassNotFoundException {
        ScoreList scoreList = (ScoreList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return scoreList;
    }
}
