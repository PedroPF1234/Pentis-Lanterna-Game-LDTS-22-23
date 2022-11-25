package org.example.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawBlock(Position position);

    void drawWall(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {LEFT, RIGHT, FULL_DOWN, ROTATE, QUIT, SELECT, NONE, DOWN}

}
