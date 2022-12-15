package org.example.viewer.game;

import org.example.model.Position;
import org.example.viewer.Viewer;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.window.Window;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Window> {
    public GameViewer(Window window) {
        super(window);
    }

    @Override
    public void drawEntities(GUI gui) throws IOException {
        drawShapes(gui, getModel().getShapes(), new ShapeViewer());
        drawWall(gui, getModel().getWalls(), new WallViewer());

        gui.drawText(new Position(32, 0), "Next Shapes", "#FFFFFF");
        gui.drawText(new Position(30, 22), "Score: " + getModel().getScore(), "#FFFFFF");
        gui.drawText(new Position(30, 16), "Level: " + (getModel().getLevel() + 1), "#FFFFFF");
        if (getModel().lostGame) {
            for (int i = 1; i < 26; i++) {
                for (int j = 0; j < 2; j++) {
                    gui.drawText(new Position(4 + 11 * j, i), "Game Over", "#FF0000");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    gui.refresh();
                }
            }
        }
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
