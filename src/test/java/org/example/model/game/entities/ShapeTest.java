package org.example.model.game.entities;

import org.example.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShapeTest {

    private Shape shape;

    @BeforeEach
    void setup() {
        shape = new Shape(5,5);
    }

    @Test
    void differentShapesAfterShifting() {
        Shape.SHAPE shapeToTest = shape.getSelectedShapeForTests();
        shape.shifted();
        Shape.SHAPE secondShapeToTest = shape.getSelectedShapeForTests();
        assertNotEquals(shapeToTest, secondShapeToTest);
    }

    @Test
    void onlyOnePossibleShiftingPerShape() {
        shape.shifted();
        assertTrue(shape.hasShifted());
        Shape.SHAPE shape1 = shape.getSelectedShapeForTests();
        shape.shifted();
        assertEquals(shape1, shape.getSelectedShapeForTests());
    }

    @Test
    void blocksUpdatedAfterShifting() {
        List<Block> list = shape.getBlocks();
        shape.shifted();
        List<Block> list2 = shape.getBlocks();
        assertNotEquals(list, list2);
    }

    @Test
    void assertRotation() {
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
        shape.setSelectedShapeForTest(Shape.SHAPE.I);
        assertEquals(shape.getBlockColour(), "#E38AAE");

        shape.setSelectedShapeForTest(Shape.SHAPE.S);
        assertEquals(shape.getBlockColour(), "#F5E216");

        shape.setSelectedShapeForTest(Shape.SHAPE.Y);
        assertEquals(shape.getBlockColour(), "#F8B88B");
    }
}