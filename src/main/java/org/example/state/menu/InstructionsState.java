package org.example.state.menu;

import org.example.controller.Controller;
import org.example.controller.menu.InstructionsController;
import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.example.state.State;
import org.example.viewer.Viewer;
import org.example.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getPainter() {
        return new InstructionsViewer(new Instructions());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(new Instructions());
    }
}
