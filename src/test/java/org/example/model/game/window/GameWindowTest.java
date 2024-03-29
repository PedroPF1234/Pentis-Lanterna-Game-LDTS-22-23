package org.example.model.game.window;

import org.example.model.Position;
import org.example.model.game.entities.Block;
import org.example.model.game.entities.Shape;
import org.example.model.game.entities.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GameWindowTest {

    private GameWindow gameWindow;

    @BeforeEach
    void setup() {
        gameWindow = new GameWindow(50, 50);
    }

    @Test
    void testDefaults() {
        GameWindow gameWindow = mock(GameWindow.class);
        assertEquals(0, gameWindow.getLevel());
        assertEquals(0, gameWindow.getScore());
        assertEquals(0, gameWindow.getWidth());
        assertEquals(0, gameWindow.getHeight());
        assertFalse(gameWindow.isPaused());
    }

    @Test
    void testPlayingShapeVariation() {
        assertNull(gameWindow.getShapes());
        List<Shape> list = new ArrayList<>();
        list.add(new Shape(5, 5));
        list.add(new Shape(6, 6));
        list.add(new Shape(7, 7));
        gameWindow.setShapes(list);
        assertEquals(gameWindow.getPlayingShape(), list.get(0));
        list.add(new Shape(8, 8));
        list.add(new Shape(9, 9));
        assertEquals(gameWindow.getPlayingShape(), list.get(2));
        for (int i = 0; i < 100; i++) {
            list.add(new Shape(5,5));
            assertEquals(gameWindow.getPlayingShape(), list.get(3+i));
        }
    }

    @Test
    void testConstructorAndSetFunctions() {
        assertEquals(50, gameWindow.getWidth());
        assertEquals(50, gameWindow.getHeight());

        gameWindow.setLevel(415);
        gameWindow.setScore(5663);
        assertEquals(415, gameWindow.getLevel());
        assertEquals(5663, gameWindow.getScore());

        List<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(10, 10));
        gameWindow.setWall(wallList);
        assertEquals(gameWindow.getWalls(), wallList);

        assertFalse(gameWindow.isPaused());
        gameWindow.pauseGame();
        assertTrue(gameWindow.isPaused());
        gameWindow.unpauseGame();
        assertFalse(gameWindow.isPaused());

        Block testBlock = new Block(10, 9);
        assertTrue(gameWindow.collisionImminent(testBlock.getPosition(), "down"));
    }

    @Test
    void nextShapeFunctionalities() {
        List<Shape> shapes = new ArrayList<>();
        Shape shape1 = new Shape(5, 5);
        Shape shape2 = new Shape(5, 5);
        Shape shape3 = new Shape(5, 5);
        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        gameWindow.setShapes(shapes);
        assertEquals(3, gameWindow.getShapes().size());

        gameWindow.getNextPlayingShape();
        assertEquals(4, gameWindow.getShapes().size());
        assertTrue(new Position(23,11).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-1).getPosition()));
        assertTrue(new Position(23,5).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-2).getPosition()));
        assertTrue(new Position(6,4).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-3).getPosition()));
        assertTrue(new Position(5,5).equals(gameWindow.getShapes().get(gameWindow.getShapes().size()-4).getPosition()));
    }

    @Test
    void levelFunctionality() {
        assertEquals(1, gameWindow.getLevel()+1);
        gameWindow.setScore(1500);
        assertEquals(1, gameWindow.getLevel()+1);
        gameWindow.updateLevel();
        assertEquals(2, gameWindow.getLevel()+1);
        gameWindow.setScore(5000);
        assertEquals(2, gameWindow.getLevel()+1);
        gameWindow.updateLevel();
        assertEquals(4, gameWindow.getLevel()+1);
    }

    @Test
    void cleanLinesFunctionality() {
        List<Shape> shapeList = new ArrayList<>();
        List<Wall> wallList = new ArrayList<>();
        Shape shape1 = new Shape(3,5);
        Shape shape2 = new Shape(8, 5);
        Shape shape3 = new Shape(11, 5);
        Shape shape4 = new Shape(12, 5);
        Shape randomShape1 = new Shape(9, 4);
        Shape randomShape2 = new Shape(9, 4);
        shape1.setSelectedShapeForTest(Shape.SHAPE.I);
        shape2.setSelectedShapeForTest(Shape.SHAPE.I);
        shape3.setSelectedShapeForTest(Shape.SHAPE.I);
        shape4.setSelectedShapeForTest(Shape.SHAPE.I);

        shape1.rotateShape();
        shape2.rotateShape();

        shape1.updateShape();
        shape2.updateShape();
        shape3.updateShape();
        shape4.updateShape();

        shapeList.add(shape1);
        shapeList.add(shape2);
        shapeList.add(shape3);
        shapeList.add(shape4);
        shapeList.add(randomShape1);
        shapeList.add(randomShape2);

        Wall wall = new Wall(0, 5);

        wallList.add(wall);

        gameWindow.setShapes(shapeList);
        gameWindow.setWall(wallList);

        assertEquals(5, shape1.getBlocks().size());
        assertEquals(5, shape2.getBlocks().size());
        assertEquals(5, shape3.getBlocks().size());
        assertEquals(5, shape4.getBlocks().size());

        gameWindow.getNextPlayingShape();

        assertEquals(0, shape1.getBlocks().size());
        assertEquals(0, shape2.getBlocks().size());
        assertEquals(4, shape3.getBlocks().size());
        assertEquals(4, shape4.getBlocks().size());
    }
}