package org.example.Painter.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Wall;

public class WallPainter implements BlockPainter<Wall> {
    @Override
    public void draw(Wall block, GUI gui, String blockColour) {
        gui.drawBlock(block.getPosition(), blockColour);
    }
}
