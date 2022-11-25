package org.example.Painter.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Block;

public interface BlockPainter<T extends Block> {
    void draw(T block, GUI gui, String blockColour);
}
