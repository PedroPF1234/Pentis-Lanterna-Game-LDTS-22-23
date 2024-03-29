package org.example.model.game.window;

import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;

import java.util.List;

public class GameWindow {
    public boolean lostGame;

    private final int width;
    private final int height;

    private int score = 1501;

    private int level = 0;

    private boolean paused = false;

    private List<Shape> shapes;

    private List<Wall> walls;

    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void setWall(List<Wall> walls) {
        this.walls = walls;
    }

    public Shape getPlayingShape() {
        return shapes.get(shapes.size() - 3);
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pauseGame() {
        this.paused = true;
    }

    public void unpauseGame() {
        this.paused = false;
    }

    public boolean collisionImminent(Position position, String direction) {
        Position position1 = new Position(position.getX(), position.getY());
        if (direction.equals("down")) {
            position1.setY(position.getY()+1);
        }
        if (direction.equals("right")) {
            position1.setX(position.getX()+1);
        }
        if (direction.equals("left")) {
            position1.setX(position.getX()-1);
        }
        if (direction.equals("own")) {
            position1.setX(position.getX());
        }

        for (Block wall : walls) {
            if (wall.getPosition().getX() == position1.getX() && wall.getPosition().getY() == position1.getY()) {
                if (wall.getPosition().getY() == 26 && !direction.equals("own")) getNextPlayingShape();
                return true;
            }
        }
        for (int i = 0; i < shapes.size()-3; i++) {
            for (Block block : shapes.get(i).getBlocks()) {
                if (block.getPosition().getX() == position1.getX() && block.getPosition().getY() == position1.getY()) {
                    if (direction.equals("down")) getNextPlayingShape();
                    return true;
                }
            }
        }
        return false;
    }

    public void getNextPlayingShape() {
        Shape to_add = new Shape(23, 11);
        shapes.get(shapes.size() - 1).setPosition(23, 5);
        shapes.get(shapes.size() - 2).setPosition(6, 4);
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
        if (numberOfLineCleared != 0) {
            switch (numberOfLineCleared) {
                case (1):
                    score += 40 * (getLevel() + 1);
                    break;
                case (2):
                    score += 100 * (getLevel() + 1);
                    break;
                case (3):
                    score += 300 * (getLevel() + 1);
                    break;
                case (4):
                    score += 1200 * (getLevel() + 1);
                    break;
                case (5):
                    score += 3000 * (getLevel() + 1);
                    break;
            }
            updateLevel();
        }
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
            for (int x = 1; x < 13; x++) {
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

    public void updateLevel() {
        if ((this.score/(1500 + ((150 * ((this.level+5)/5)) * this.level))) >= this.level) {
            this.level = (this.score / (1500 + ((150 * ((this.level + 5) / 5)) * this.level)));
        }
    }
}
