package org.example.model.game.entities;

import org.example.model.Position;

public class Block {

    private Position position;
    public Block(int x, int y) {
        this.position = new Position(x, y);
    }
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }
}
