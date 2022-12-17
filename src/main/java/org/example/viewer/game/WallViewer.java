package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Wall;

public class WallViewer implements BlockViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui, String wallColour) {
        gui.drawBlock(wall.getPosition(), wallColour);
    }
}
