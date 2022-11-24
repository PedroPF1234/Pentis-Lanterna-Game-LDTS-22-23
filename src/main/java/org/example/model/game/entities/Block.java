package org.example.model.game.entities;

import org.example.model.Position;

public abstract class Block {

    private Position position;

    public Block(int x, int y) {
        this.position = new Position(x, y);
    }

    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public Position getPosition() {
        return position;
    }
}
