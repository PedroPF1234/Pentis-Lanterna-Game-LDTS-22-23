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
        drawShape(gui, getModel().getShape().getBlocks(), new ShapePainter(), getModel().getShape().getBlockColour());
        drawWall(gui, getModel().getWalls(), new WallPainter());
    }

    private void drawWall(GUI gui, List<Block> walls, WallPainter wallPainter) {
        for (Block block : walls) {
            drawBlock(gui, block, wallPainter, "#FFFFFF");
        }
    }

    private <T extends Block> void drawShape(GUI gui, List<T> blocks, ShapePainter shapePainter, String blockColour) {
        for (Block block : blocks) {
            drawBlock(gui, block, shapePainter, blockColour);
        }
    }

    private <T extends BlockPainter> void drawBlock(GUI gui, Block block, T painter, String blockColour) {
        painter.draw(block, gui, blockColour);
    }
}
