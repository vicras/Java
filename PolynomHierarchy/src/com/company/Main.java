package com.company;

import com.company.controller.Controlable;
import com.company.controller.Controller;
import com.company.model.TaskPerformer;
import com.company.model.Taskable;
import com.company.view.ConsoleOutputer;
import com.company.view.ViewInterface;

public class Main {

    public static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Taskable model = new TaskPerformer();
        ViewInterface viewInterface = new ConsoleOutputer();
        Controlable controller = new Controller(viewInterface, model);
        controller.init();
    }
}

