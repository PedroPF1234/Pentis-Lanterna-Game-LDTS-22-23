package org.example.model.game.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shape extends Block{
    enum SHAPE {F, I, L, S, P, T, U, V, W, X, Y, Z, FM, LM, SM, PM, YM, ZM, NONE}
    private List<Block> blocks;
    private int rotation = 0;
    private final  SHAPE selectedShape;
    private final String blockColour;

    public Shape(int x, int y) {
        super(x,y);
        selectedShape = SHAPE.I;
        this.blocks = constructShape(selectedShape);
        this.blockColour = getColourOfShape(selectedShape);

    }

    private String getColourOfShape(SHAPE selectedShape) {
        if (selectedShape == SHAPE.F) return "#8B0000";
        if (selectedShape == SHAPE.I) return "#FFA07A";
        if (selectedShape == SHAPE.L) return "#FFC0CB";
        if (selectedShape == SHAPE.S) return "#FF8C00";
        if (selectedShape == SHAPE.P) return "#FFFF00";
        if (selectedShape == SHAPE.T) return "#BDB76B";
        if (selectedShape == SHAPE.U) return "#663399";
        if (selectedShape == SHAPE.V) return "#191970";
        if (selectedShape == SHAPE.W) return "#8B4513";
        if (selectedShape == SHAPE.X) return "#4682B4";
        if (selectedShape == SHAPE.Y) return "#EE82EE";
        if (selectedShape == SHAPE.Z) return "#00FF00";
        if (selectedShape == SHAPE.FM) return "#DC143C";
        if (selectedShape == SHAPE.LM) return "#FF1493";
        if (selectedShape == SHAPE.SM) return "#FF4500";
        if (selectedShape == SHAPE.PM) return "#FAFAD2";
        if (selectedShape == SHAPE.YM) return "#FF00FF";
        if (selectedShape == SHAPE.ZM) return "#90EE90";
        return null;
    }

    private List<Block> constructShape(SHAPE selectedShape) {
        List<Block> blocks = new ArrayList<>();
        if (selectedShape == SHAPE.I && (rotation == 0  || rotation == 2)) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
        }
        if (selectedShape == SHAPE.I && (rotation == 1  || rotation == 3)) {
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.L && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.L && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.L && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.L && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.U && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.U && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.U && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.U && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.T && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.T && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.T && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.T && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.P && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.P && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.P && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.P && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.F && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.F && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.F && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.F && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.S && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.S && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
        }
        if (selectedShape == SHAPE.S && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.S && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
        }
        if (selectedShape == SHAPE.V && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.V && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.V && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.V && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.W && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.W && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.W && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.W && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.X) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.Y && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.Y && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.Y && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.Y && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.Z && (rotation == 0 || rotation == 2)) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.Z && (rotation == 1 || rotation == 3)) {
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.FM && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.FM && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.FM && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.FM && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.LM && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.LM && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.LM && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.LM && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.SM && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.SM && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
        }
        if (selectedShape == SHAPE.SM && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.SM && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
        }
        if (selectedShape == SHAPE.PM && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.PM && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.PM && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.PM && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.YM && rotation == 0) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.YM && rotation == 1) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
        }
        if (selectedShape == SHAPE.YM && rotation == 2) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 4, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
        }
        if (selectedShape == SHAPE.YM && rotation == 3) {
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 2));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.ZM && (rotation == 0 || rotation == 2)) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() - 1));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() + 1));
        }
        if (selectedShape == SHAPE.ZM && (rotation == 1 || rotation == 3)) {
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY() + 1));
            blocks.add(new Block(this.getPosition().getX() + 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX(), this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY()));
            blocks.add(new Block(this.getPosition().getX() - 2, this.getPosition().getY() - 1));
        }
        return blocks;
    }

    public SHAPE getNextShape() {
        Random random = new Random();
        int randomShape = random.nextInt(18);

        if (randomShape == 0) return SHAPE.Z;
        if (randomShape == 1) return SHAPE.F;
        if (randomShape == 2) return SHAPE.I;
        if (randomShape == 3) return SHAPE.L;
        if (randomShape == 4) return SHAPE.S;
        if (randomShape == 5) return SHAPE.P;
        if (randomShape == 6) return SHAPE.T;
        if (randomShape == 7) return SHAPE.U;
        if (randomShape == 8) return SHAPE.V;
        if (randomShape == 9) return SHAPE.W;
        if (randomShape == 10) return SHAPE.X;
        if (randomShape == 11) return SHAPE.Y;
        if (randomShape == 12) return SHAPE.FM;
        if (randomShape == 13) return SHAPE.LM;
        if (randomShape == 14) return SHAPE.SM;
        if (randomShape == 15) return SHAPE.ZM;
        if (randomShape == 16) return SHAPE.YM;
        if (randomShape == 17) return SHAPE.PM;
        return SHAPE.NONE;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public String getBlockColour() {
        return blockColour;
    }

    public int getRotation() {
        return rotation;
    }

    public void pushShapeRight() {
        this.setPosition(this.getPosition().getRight());
        updateShape();
    }

    public void  pushShapeLeft() {
        this.setPosition(this.getPosition().getLeft());
        updateShape();
    }
    public void pushShapeDown() {
        this.setPosition(this.getPosition().getX(), this.getPosition().getY() + 1);
        updateShape();
    }

    public void pushShapeUp() {
        this.setPosition(this.getPosition().getX(), this.getPosition().getY() - 1);
        updateShape();
    }

    public void updateShape() {
        this.blocks = constructShape(selectedShape);
    }

    public void rotateShape() {
        if (rotation == 3) rotation = 0;
        else rotation++;
    }

}
