package org.example.Painter.game;

import org.example.Painter.Painter;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.window.Window;

import java.util.List;

public class GamePainter extends Painter<Window> {
    public GamePainter(Window window) {
        super(window);
    }

    @Override
    public void drawEntities(GUI gui) {
        drawShape(gui, getModel().getShapes(), new ShapePainter());
        drawWall(gui, getModel().getWalls(), new WallPainter());
    }

    private void drawWall(GUI gui, List<Block> walls, WallPainter wallPainter) {
        for (Block block : walls) {
            drawBlock(gui, block, wallPainter, "#FFFFFF");
        }
    }

    private void drawShape(GUI gui, List<Shape> shapes, ShapePainter shapePainter) {
        for (Shape shape : shapes) {
            String blockColour = shape.getBlockColour();
            for (Block block : shape.getBlocks()) {
                drawBlock(gui, block, shapePainter, blockColour);
            }
        }
    }

    private <T extends BlockPainter> void drawBlock(GUI gui, Block block, T painter, String blockColour) {
        painter.draw(block, gui, blockColour);
    }
}
