package org.example.model.game.window;

import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;

import java.util.List;

import static java.lang.Math.pow;

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
        for (int i = shapes.size() - 3; i < shapes.size(); i++) {
            shapes.get(i).updateShape();
        }
        lostGame = losingConditionCheck(getPlayingShape());
        int numberOfLineCleared = 0;
        while (filledLineCheck() != 0) {
            cleanLine(filledLineCheck());
            numberOfLineCleared++;
        }
        score += ((100 * numberOfLineCleared * getLevel()) + (pow(2, numberOfLineCleared - 1)*(10*numberOfLineCleared - 1)));
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

    private int filledLineCheck() {
        int count = 0;
        for (int y = 1; y < 26; y++) {
            for (int x = 2; x < 25; x += 2) {
                for (int i = 0; i < shapes.size() - 3; i++) {
                    for (Block block : shapes.get(i).getBlocks()) {
                        if (block.getPosition().getX() == x && block.getPosition().getY() == y) {
                            count++;
                        }
                    }
                }
            }
            if (count == 12) return y;
            count = 0;
        }
        return 0;
    }

    private void cleanLine(int line) {
        for (Shape shape : shapes) {
            int numBlocks = shape.getBlocks().size();
            for (int i = 0; i < numBlocks; i++) {
                if (shape.getBlocks().get(i).getPosition().getY() == line) {
                    shape.getBlocks().remove(shape.getBlocks().get(i));
                    numBlocks--;
                    i--;
                }
            }
        }
        for (int i = 0; i < shapes.size() - 3; i++) {
            for (Block block : shapes.get(i).getBlocks()) {
                if (block.getPosition().getY() < line) {
                    block.setPosition(block.getPosition().getX(), block.getPosition().getY() + 1);
                }
            }
        }
    }
}
