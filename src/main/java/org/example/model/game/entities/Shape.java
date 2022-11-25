package org.example.model.game.entities;

import java.util.List;
import java.util.Random;

public class Shape extends Block{

    enum SHAPE {F, I, L, N, P, T, U, V, W, X, Y, Z, NONE}
    private SHAPE selectedShape;
    private List<Block> blocks;

    public Shape(int x, int y) {
        super(x,y);
        selectedShape = getNextShape();
    }

    public SHAPE getNextShape() {
        Random random = new Random();
        int randomShape = random.nextInt(13);

        if (randomShape == 0) return SHAPE.Z;
        if (randomShape == 1) return SHAPE.F;
        if (randomShape == 2) return SHAPE.I;
        if (randomShape == 3) return SHAPE.L;
        if (randomShape == 4) return SHAPE.N;
        if (randomShape == 5) return SHAPE.P;
        if (randomShape == 6) return SHAPE.T;
        if (randomShape == 7) return SHAPE.U;
        if (randomShape == 8) return SHAPE.V;
        if (randomShape == 9) return SHAPE.W;
        if (randomShape == 10) return SHAPE.X;
        if (randomShape == 11) return SHAPE.Y;
        return SHAPE.NONE;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    //Metodo de o fazer cair a cada x segundos ou loops

    //Metodo de colisoes

    //Metodo de mover o bloco side to side ou rotacao

}
