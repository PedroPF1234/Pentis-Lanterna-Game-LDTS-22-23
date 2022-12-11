package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Block;

public class ShapeViewer implements BlockViewer<Block> {


    @Override
    public void draw(Block block, GUI gui, String blockColour) {
            gui.drawBlock(block.getPosition(), blockColour);
    }
}
