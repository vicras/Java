package com.company;

import com.company.controller.Controlable;
import com.company.controller.ControllerImpl;
import com.company.model.Taskable;
import com.company.model.TaskableImpl;
import com.company.view.ViewInterface;
import com.company.view.ViewInterfaceImpl;

public class Main {

    public static void main(String[] args) {
        Taskable task = new TaskableImpl();
        ViewInterface view = new ViewInterfaceImpl();
        Controlable controller = new ControllerImpl(task, view);
        controller.init();
    }
}
