package org.example.model.game.window;

import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;

import java.util.List;

public class Window {
    private final int width;
    private final int height;

    private List<Shape> shapes;

    private List<Block> walls;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
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

    public Shape getPlayingShape() {
        return shapes.get(shapes.size() - 3);
    }

    public List<Block> getWalls() {
        return walls;
    }

    public boolean collisionImminent(Position position, String direction) {
        Position position1 = new Position(position.getX(), position.getY());
        if (direction.equals("down")) {
            position1.setY(position.getY()+1);
        }
        if (direction.equals("right")) {
            position1.setX(position.getX()+2);
        }
        if (direction.equals("left")) {
            position1.setX(position.getX()-2);
        }
        for (Block wall : walls) {
            if (wall.getPosition().getX() == position1.getX() && wall.getPosition().getY() == position1.getY()) return true;
            //Condition to test against other shapes.
        }
        return false;
    }
}
