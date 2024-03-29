package org.example.state.menu;

import org.example.state.State;
import org.example.viewer.menu.MenuViewer;
import org.example.viewer.Viewer;
import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
