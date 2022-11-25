package org.example.model.game.window;

import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.ArrayList;
import java.util.List;

public class WindowBuilderLoader extends WindowBuilder{
    @Override
    protected Shape createShaper() {
        return new Shape(5, 5);
    }

    @Override
    protected List<Shape> createShapes() {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shapes.add(new Shape(5, 5));
        }
        return shapes;
    }

    @Override
    protected List<Block> createWalls() {
        List<Block> wall = new ArrayList<>();

        for (int x = 0; x < getWidth() - 3; x++) {
            for (int y = 0; y < getHeight(); y++) {

                if (x == 0) wall.add(new Wall(x, y));
                if (x == getWidth() - 4) wall.add(new Wall(x, y));
                if (y == 0 && x != 0 && x != getWidth() - 1) wall.add(new Wall(x, y));
                if (y == getHeight() - 1 && x != 0 && x != getWidth() - 1) wall.add(new Wall(x, y));
            }
        }


        return wall;
    }
    @Override
    protected int getWidth() {
        return 30;
    }

    @Override
    protected int getHeight() {
        return 27;
    }
}
