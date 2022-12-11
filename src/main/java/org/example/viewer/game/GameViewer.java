package org.example.viewer.game;

import org.example.viewer.Viewer;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.window.Window;

import java.util.List;

public class GameViewer extends Viewer<Window> {
    public GameViewer(Window window) {
        super(window);
    }

    @Override
    public void drawEntities(GUI gui) {
        drawShapes(gui, getModel().getShapes(), new ShapeViewer());
        drawWall(gui, getModel().getWalls(), new WallViewer());
    }

    private void drawWall(GUI gui, List<Block> walls, WallViewer wallViewer) {
        for (Block block : walls) {
            drawBlock(gui, block, wallViewer, "#FFFFFF");
        }
    }

    private void drawShapes(GUI gui, List<Shape> shapes, ShapeViewer shapeViewer) {
        for (Shape shape : shapes) {
            String blockColour = shape.getBlockColour();
            for (Block block : shape.getBlocks()) {
                drawBlock(gui, block, shapeViewer, blockColour);
            }
        }
    }

    private <T extends BlockViewer> void drawBlock(GUI gui, Block block, T viewer, String blockColour) {
        viewer.draw(block, gui, blockColour);
    }
}
