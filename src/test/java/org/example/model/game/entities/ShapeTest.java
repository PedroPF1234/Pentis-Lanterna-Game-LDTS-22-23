package org.example.model.game.entities;

import org.example.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShapeTest {

    @Test
    void differentShapesAfterShifting() {
        Shape shape = new Shape(5,5);
        Shape.SHAPE shapeToTest = shape.getSelectedShapeForTests();
        shape.shifted();
        Shape.SHAPE secondShapeToTest = shape.getSelectedShapeForTests();
        assertNotEquals(shapeToTest, secondShapeToTest);
    }

    @Test
    void onlyOnePossibleShiftingPerShape() {
        Shape shape = new Shape(5,5);
        shape.shifted();
        assertTrue(shape.hasShifted());
    }

    @Test
    void blocksUpdatedAfterShifting() {
        Shape shape = new Shape(5, 5);
        List<Block> list = shape.getBlocks();
        shape.shifted();
        List<Block> list2 = shape.getBlocks();
        assertNotEquals(list, list2);
    }

    @Test
    void assertRotation() {
        Shape shape = new Shape(5, 5);
        assertEquals(0, shape.getRotation());
        shape.rotateShape();
        assertEquals(1, shape.getRotation());
        for (int i = 0; i < 3; i++) {
            shape.rotateShape();
        }
        assertEquals(0, shape.getRotation());
    }

    @Test
    void shapeMovement() {
        Shape shape = new Shape(5,5);
        assertTrue(shape.getPosition().equals(new Position(5, 5)));
        shape.pushShapeLeft();
        assertTrue(shape.getPosition().equals(new Position(4, 5)));
        shape.pushShapeDown();
        assertTrue(shape.getPosition().equals(new Position(4, 6)));
        shape.pushShapeRight();
        assertTrue(shape.getPosition().equals(new Position(5, 6)));
        for (int i = 0; i < 3; i++) {
            shape.pushShapeUp();
        }
        assertTrue(shape.getPosition().equals(new Position(5, 3)));
    }

    @Test
    void shapeColour() {
        Shape shape = new Shape(5,5);
        shape.setSelectedShapeForTest(Shape.SHAPE.I);
        String colour = shape.getBlockColour();
        assertEquals(colour, "#E38AAE");
    }
}