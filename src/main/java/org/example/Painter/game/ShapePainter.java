package org.example.Painter.game;

import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;

public class ShapePainter implements BlockPainter<Block> {


    @Override
    public void draw(Block block, GUI gui, String blockColour) {
            gui.drawBlock(block.getPosition(), blockColour);
    }
}
