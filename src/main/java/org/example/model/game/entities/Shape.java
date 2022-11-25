package org.example.model.game.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shape extends Block{

    enum SHAPE {F, I, L, S, P, T, U, V, W, X, Y, Z, NONE,FM,LM,SM,PM,YM,ZM}
    private final SHAPE selectedShape;
    private final List<Block> blocks;

    public Shape(int x, int y) {
        super(x,y);
        selectedShape = SHAPE.X;
        this.blocks = constructShape(selectedShape);

    }

    private List<Block> constructShape(SHAPE selectedShape) {
        List<Block> blocks = new ArrayList<>();
        if (selectedShape == SHAPE.I) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(4, 7));
            blocks.add(new Block(4, 8));
            blocks.add(new Block(4, 9));
        }
        if (selectedShape == SHAPE.L) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(4, 7));
            blocks.add(new Block(4, 8));
            blocks.add(new Block(6, 8));
        }
        if (selectedShape == SHAPE.U) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(2, 5));
            blocks.add(new Block(2, 6));
            blocks.add(new Block(6, 5));
            blocks.add(new Block(6, 6));
        }
        if (selectedShape == SHAPE.T) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(2, 5));
            blocks.add(new Block(6, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(4, 7));
        }
        if (selectedShape == SHAPE.P) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(6, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(6, 6));
            blocks.add(new Block(4, 7));
        }
        if (selectedShape == SHAPE.F) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(6, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(2, 6));
            blocks.add(new Block(4, 7));
        }
        if (selectedShape == SHAPE.S) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(6, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(2, 6));
            blocks.add(new Block(0, 6));
        }
        if (selectedShape == SHAPE.V) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(4, 7));
            blocks.add(new Block(6, 7));
            blocks.add(new Block(8, 7));
        }
        if (selectedShape == SHAPE.W) {
            blocks.add(new Block(4, 5));
            blocks.add(new Block(4, 6));
            blocks.add(new Block(6, 6));
            blocks.add(new Block(6, 7));
            blocks.add(new Block(8, 7));
        }
        if (selectedShape == SHAPE.X) {
            blocks.add(new Block(4, 6));
            blocks.add(new Block(4, 5));
            blocks.add(new Block(2, 6));
            blocks.add(new Block(6, 6));
            blocks.add(new Block(4, 7));
        }
        if (selectedShape == SHAPE.Y) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(5, 6));
            blocks.add(new Block(3, 6));
            blocks.add(new Block(1, 6));
            blocks.add(new Block(7, 6));
        }
        if (selectedShape == SHAPE.Z) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(7, 5));
            blocks.add(new Block(7, 6));
            blocks.add(new Block(7, 7));
            blocks.add(new Block(9, 7));
        }
        if (selectedShape == SHAPE.FM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(3, 5));
            blocks.add(new Block(5, 6));
            blocks.add(new Block(7, 6));
            blocks.add(new Block(5, 7));
        }
        if (selectedShape == SHAPE.LM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(5, 6));
            blocks.add(new Block(5, 7));
            blocks.add(new Block(5, 8));
            blocks.add(new Block(3, 8));
        }
        if (selectedShape == SHAPE.SM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(7, 5));
            blocks.add(new Block(7, 6));
            blocks.add(new Block(9, 6));
            blocks.add(new Block(11, 6));
        }
        if (selectedShape == SHAPE.PM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(7, 5));
            blocks.add(new Block(5, 6));
            blocks.add(new Block(7, 6));
            blocks.add(new Block(7, 7));
        }
        if (selectedShape == SHAPE.YM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(5, 6));
            blocks.add(new Block(3, 6));
            blocks.add(new Block(7, 6));
            blocks.add(new Block(9, 6));
        }
        if (selectedShape == SHAPE.ZM) {
            blocks.add(new Block(5, 5));
            blocks.add(new Block(3, 5));
            blocks.add(new Block(3, 6));
            blocks.add(new Block(3, 7));
            blocks.add(new Block(1, 7));
        }
        return blocks;
    }

    public SHAPE getNextShape() {
        Random random = new Random();
        int randomShape = random.nextInt(19);

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

    //Metodo de o fazer cair a cada x segundos ou loops

    //Metodo de colisoes

    //Metodo de mover o bloco side to side ou rotacao

}
