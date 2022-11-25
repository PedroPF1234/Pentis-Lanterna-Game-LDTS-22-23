package org.example.gamestate;

import org.example.Painter.menu.MenuPainter;
import org.example.Painter.Painter;
import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;

public class MenuState extends State<Menu> {

    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Painter<Menu> getPainter() {
        return new MenuPainter(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
