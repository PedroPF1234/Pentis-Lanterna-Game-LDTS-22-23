package org.example;

import org.example.gamestate.GameState;
import org.example.gamestate.State;
import org.example.gamestate.MenuState;
import org.example.gui.LanternaGUI;
import org.example.model.menu.Menu;

import java.io.IOException;

public class MainGame {

    private LanternaGUI gui;
    private State state;


    public MainGame() throws IOException {
        this.gui = new LanternaGUI(100, 50);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException {
       new MainGame().startGame();
    }

    public void setState(State state) {
        this.state = state;
    }


    public void startGame() throws IOException {
        final int FPS = 60;
        int frameTime = 1000/FPS;

      while (this.state != null) {

            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        gui.close();
    }
}
