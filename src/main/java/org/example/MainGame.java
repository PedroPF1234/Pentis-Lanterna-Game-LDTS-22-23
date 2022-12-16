package org.example;

import org.example.state.State;
import org.example.state.menu.MenuState;
import org.example.gui.LanternaGUI;
import org.example.model.menu.Menu;

import java.awt.*;
import java.io.IOException;

public class MainGame {

    private LanternaGUI gui;
    private State state;

    private final int FPS = 60 ;
    public LanternaGUI getGui() {
        return gui;
    }

    public State getState() {
        return state;
    }

    public MainGame() throws IOException, FontFormatException {
        this.gui = new LanternaGUI(50, 27);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, InterruptedException, FontFormatException {
       new MainGame().startGame();
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getFPS() {
        return FPS;
    }

    public void startGame() throws IOException, InterruptedException {
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
