package org.example.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawBlock(Position position, String blockColour);

    void drawText(Position position, String text, String color);

    void drawTextChar(Position position, char charToDraw, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {LEFT, RIGHT, FULL_DOWN, ROTATE, QUIT, SELECT, NONE, DOWN, SHAPE_SHIFT, DELETE, PAUSE}

}
