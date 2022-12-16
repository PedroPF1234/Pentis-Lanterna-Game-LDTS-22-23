package org.example.model.game.window;

import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.ArrayList;
import java.util.List;

public class WindowBuilderLoader extends WindowBuilder{

    @Override
    protected List<Shape> createShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape(6, 4));
        for (int i = 0; i < 2; i++) {
            shapes.add(new Shape(23, 5 + i*6));
        }
        return shapes;
    }

    @Override
    protected List<Block> createWalls() {
        List<Block> wall = new ArrayList<>();

        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 27; y++) {

                if (x == 0) wall.add(new Wall(x, y));
                if (x == 13) wall.add(new Wall(x, y));
                if (y == 0 && x != 0 && x != 13) wall.add(new Wall(x, y));
                if (y == 26 && x != 0 && x != 13) wall.add(new Wall(x, y));
            }
        }


        return wall;
    }
    @Override
    protected int getWidth() {
        return 50;
    }

    @Override
    protected int getHeight() {
        return 27;
    }
}
