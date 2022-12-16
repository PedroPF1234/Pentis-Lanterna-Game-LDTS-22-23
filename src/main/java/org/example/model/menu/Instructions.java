package org.example.model.menu;

import org.example.model.game.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Instructions {
    private final List<Shape> shapeList = new ArrayList<>();
    public Instructions() {
        shapeList.add(new Shape(28, 6));
        shapeList.add(new Shape(42, 6));
        shapeList.get(1).rotateShape();
        for (Shape shape : shapeList) {
            shape.setSelectedShapeForTest();
            shape.updateShape();
        }
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
}
