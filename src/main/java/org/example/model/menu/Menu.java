package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> selections;
    private int currentSelection = 0;

    public Menu() {
        this.selections = Arrays.asList("Start", "HighScores", "Exit");
    }

    public void nextSelection() {
        currentSelection++;
        if (currentSelection > this.selections.size() - 1)
            currentSelection = 0;
    }

    public void  previousSelections() {
        currentSelection--;
        if (currentSelection < 0) {
            currentSelection = this.selections.size() -1;
        }
    }

    public String getSelection (int i) {
        return selections.get(i);
    }

    public boolean isSelected (int i) {
        return currentSelection == i;
    }

    public boolean isSelectedExit() {
        return isSelected(this.selections.size() - 1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberSelections() {
        return this.selections.size();
    }
}
