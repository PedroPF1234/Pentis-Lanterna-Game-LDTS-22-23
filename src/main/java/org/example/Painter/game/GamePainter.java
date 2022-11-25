package org.example.Painter.game;

import org.example.Painter.Painter;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.window.Window;

import java.util.List;

public class GamePainter extends Painter<Window> {
    public GamePainter(Window window) {
        super(window);
    }

    @Override
    public void drawEntities(GUI gui) {
        drawShape(gui, getModel().getShape().getBlocks(), new ShapePainter());
    }

    private <T extends Block> void drawShape(GUI gui, List<T> blocks, ShapePainter painter) {
        for (Block block : blocks) {
            drawBlock(gui, block, painter);
        }
    }

    private <T extends Block> void drawBlock(GUI gui, T block, ShapePainter painter) {
        painter.draw(block, gui);
    }
}
