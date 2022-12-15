package org.example.model.game.window;

import org.example.gamestate.MenuState;
import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.menu.Menu;

import java.util.List;

public class Window {
    public boolean lostGame;

    private final int width;
    private final int height;

    private int score = 0;

    private int level = 0;

    private List<Shape> shapes;

    private List<Block> walls;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        if (direction.equals("own")) {
            position1.setX(position.getX());
        }

        for (Block wall : walls) {
            if (wall.getPosition().getX() == position1.getX() && wall.getPosition().getY() == position1.getY()) {
                if (wall.getPosition().getY() == 26 && !direction.equals("own")) nextPlayingShape();
                return true;
            }
        }
        for (int i = 0; i < shapes.size()-3; i++) {
            for (Block block : shapes.get(i).getBlocks()) {
                if (block.getPosition().getX() == position1.getX() && block.getPosition().getY() == position1.getY()) {
                    if (direction.equals("down")) nextPlayingShape();
                    return true;
                }
            }
        }
        return false;
    }

    public void nextPlayingShape() {
        Shape to_add = new Shape(36, 10);
        shapes.get(shapes.size() - 1).setPosition(36, 4);
        shapes.get(shapes.size() - 2).setPosition(12, 4);
        shapes.add(to_add);
        for (Shape shape : shapes) {
            shape.updateShape();
        }
        lostGame = losingConditionCheck(getPlayingShape());
        //Adicionar method call para verificar se ha alguma linha cheia
    }

    private boolean losingConditionCheck(Shape shape) {
        for (Block blockToSpawn : shape.getBlocks()) {
            for (int i = 0; i < shapes.size() - 3; i++) {
                for (Block block : shapes.get(i).getBlocks()) {
                    if (blockToSpawn.getPosition().equals(block.getPosition())) return true;
                }
            }
        }
        return false;
    }
}
