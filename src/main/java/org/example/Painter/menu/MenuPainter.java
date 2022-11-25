package org.example.Painter.menu;

import org.example.Painter.Painter;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;

public class MenuPainter extends Painter<Menu> {
    public MenuPainter(Menu menu) {
        super(menu);
    }

    @Override
    public void drawEntities(GUI gui) {
        gui.drawText(new Position(5,5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberSelections(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getSelection(i),
            getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
