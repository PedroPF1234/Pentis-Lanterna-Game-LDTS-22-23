package org.example.model.menu.Score;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ScoreWriter {
    ObjectOutputStream objectOutputStream;
    FileOutputStream fileOutputStream;

    public ScoreWriter() throws IOException {
        fileOutputStream = new FileOutputStream(new File("src/main/resources/highscores/scores.txt"));
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }

    public void writeInFile(ScoreList scoreList) throws IOException {
        objectOutputStream.writeObject(scoreList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
