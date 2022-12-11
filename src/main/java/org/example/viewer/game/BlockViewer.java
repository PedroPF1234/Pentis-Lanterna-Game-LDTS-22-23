package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Block;

public interface BlockViewer<T extends Block> {
    void draw(T block, GUI gui, String blockColour);
}
