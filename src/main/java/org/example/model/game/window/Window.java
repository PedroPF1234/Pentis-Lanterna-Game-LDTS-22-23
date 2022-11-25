package org.example.model.game.window;

import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.List;

public class Window {
    private final int width;
    private final int height;

    private List<Shape> shapes;

    private Shape shape;

    private List<Block> walls;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setWall(List<Block> walls) {
        this.walls = walls;
    }

    public Shape getShape() {
        return shape;
    }

    public List<Block> getWalls() {
        return walls;
    }

    public boolean isEmpty(Position position) {
        for (Block wall : walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        return true;
    }
}
