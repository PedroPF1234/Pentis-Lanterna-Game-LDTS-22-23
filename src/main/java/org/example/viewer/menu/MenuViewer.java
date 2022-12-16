package org.example.viewer.menu;

import org.example.viewer.Viewer;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawEntities(GUI gui) {
        gui.drawText(new Position(5,5), "menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberSelections(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getSelection(i),
            getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
