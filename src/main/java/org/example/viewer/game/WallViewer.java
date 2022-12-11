package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Wall;

public class WallViewer implements BlockViewer<Wall> {
    @Override
    public void draw(Wall block, GUI gui, String blockColour) {
        gui.drawBlock(block.getPosition(), blockColour);
    }
}
