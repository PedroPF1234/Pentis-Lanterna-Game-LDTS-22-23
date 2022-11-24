package org.example.controller.menu;

import org.example.MainGame;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Menu;

import java.io.IOException;

public class MenuController extends Controller<Menu> {


    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(MainGame game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousSelections();
                break;
            case DOWN:
                getModel().nextSelection();
            case SELECT:
                if(getModel().isSelectedExit()) {
                    //Game state set to null to end gameplay loop.
                }
                if (getModel().isSelectedStart()) {
                    //Game state set to start a new game
                }

        }
    }
}
