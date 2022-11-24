package org.example.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Exit");
    }
}
