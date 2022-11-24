package org.example;

import com.googlecode.lanterna.TextCharacter;
import org.example.gui.LanternaGUI;
import org.example.model.Position;

import java.io.IOException;

public class MainGame {

    private LanternaGUI gui;
  //private GameState state;  GameState defined as a field for the MainGame class.


    public MainGame() throws IOException {
        this.gui = new LanternaGUI(40, 20);
        //Game states initializer
    }

    public static void main(String[] args) throws IOException {
       new MainGame().startGame();
    }

    //Method to set game state


    public void startGame() throws IOException {
        final int FPS = 10;
        int frameTime = 1000/FPS;

      //while (this.state != null) {    When game states is implemented, run game until GameState is null.
        while (true) {
            long startTime = System.currentTimeMillis();

            //Somehow, use gamestates to start the game mechanics, such as draw onto gui and spawn entities.

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gui.clear();
            gui.drawText(new Position(13,9), String.valueOf(System.currentTimeMillis()), "#FFFFFF");
            gui.refresh();
        }
    }
}
