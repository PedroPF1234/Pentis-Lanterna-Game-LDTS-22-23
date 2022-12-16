package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.game.BlockViewer;
import org.example.viewer.game.ShapeViewer;

import java.io.IOException;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions model) {
        super(model);
    }

    @Override
    public void drawEntities(GUI gui) throws IOException {
        ShapeViewer shapeViewer = new ShapeViewer();
        for (Shape shape : getModel().getShapeList()) {
            for (Block block : shape.getBlocks()) {
                drawBlock(gui, block, shapeViewer, shape.getBlockColour());
            }
        }
        gui.drawText(new Position(33, 6), "->", "#FFFFFF");
        gui.drawText(new Position(2, 5), "Press Arrow_Up", "#FFFFFF");
        gui.drawText(new Position(2, 6), "to rotate shape", "#FFFFFF");
        gui.drawText(new Position(2, 10), "Press Arrow_Right to push the shape right.", "#FFFFFF");
        gui.drawText(new Position(2, 11), "Press Arrow_Left to push the shape left.", "#FFFFFF");
        gui.drawText(new Position(2, 12), "Press Arrow_Down to push the shape down.", "#FFFFFF");
        gui.drawText(new Position(2, 13), "exactly one block. Alternatively, press", "#FFFFFF");
        gui.drawText(new Position(2, 14), "Space_Bar to push the shape all the way down.", "#FFFFFF");
        gui.drawText(new Position(2, 16), "Press Tab to shape shift, also know as,", "#FFFFFF");
        gui.drawText(new Position(2, 17), "getting a new random shape to play with.", "#FFFFFF");
        gui.drawText(new Position(2, 18), "The shape shift ability can only be used", "#FFFFFF");
        gui.drawText(new Position(2, 19), "once per round.", "#FFFFFF");
        gui.drawText(new Position(2, 21), "Press Esc to return to the Menu at any", "#FFFFFF");
        gui.drawText(new Position(2, 22), "instance of the game.", "#FFFFFF");
    }

    private <T extends BlockViewer> void drawBlock(GUI gui, Block block, T viewer, String blockColour) {
        viewer.draw(block, gui, blockColour);
    }
}
