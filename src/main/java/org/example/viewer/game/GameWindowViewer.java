package org.example.viewer.game;

import org.example.model.Position;
import org.example.model.game.entities.Wall;
import org.example.model.game.window.GameWindow;
import org.example.viewer.Viewer;
import org.example.gui.GUI;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;

import java.io.IOException;
import java.util.List;

public class GameWindowViewer extends Viewer<GameWindow> {
    public GameWindowViewer(GameWindow gameWindow) {
        super(gameWindow);
    }

    @Override
    public void drawEntities(GUI gui) throws IOException {
        drawShapes(gui, getModel().getShapes(), new ShapeViewer());
        drawWall(gui, getModel().getWalls(), new WallViewer());

        if (getModel().isPaused()) {
            gui.drawText(new Position(30, 12), "the game is paused!", "#FF0000");
        }

        gui.drawText(new Position(18, 1), "next shapes", "#FFFFFF");
        gui.drawText(new Position(18, 23), "score: " + getModel().getScore(), "#FFFFFF");
        gui.drawText(new Position(18, 17), "level: " + (getModel().getLevel() + 1), "#FFFFFF");
        if (getModel().lostGame) {
            for (int i = 1; i < 26; i++) {
                if (i % 2 == 0) {
                    gui.drawText(new Position(1, i), " game over  ", "#FF0000");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    gui.refresh();
                }
                else {
                    gui.drawText(new Position(1, i), "  game over ", "#FF0000");
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

    private void drawWall(GUI gui, List<Wall> walls, WallViewer wallViewer) {
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

    private <T extends BlockViewer<Block>> void drawBlock(GUI gui, Block block, T viewer, String blockColour) {
        viewer.draw(block, gui, blockColour);
    }
}
