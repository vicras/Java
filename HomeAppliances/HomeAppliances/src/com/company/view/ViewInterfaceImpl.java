package com.company.view;

import com.company.controller.Controlable;
import com.company.model.Taskable;

import java.util.Scanner;

public class ViewInterfaceImpl implements ViewInterface {
    Controlable controller;
    Taskable model;

    @Override
    public void init(Controlable controller, Taskable task) {
        this.controller = controller;
        this.model = task;

        gui();
    }

    /**
     * method, such perform gui execution
     */
    void gui() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to lab02 representer ");
        System.out.println("Graskov Viktor 2020 all rights reserved ");
        System.out.println("use this command words:");
        System.out.println("getList - to get List of Home Electrical Appliances");
        System.out.println("sortBySize - to show example of sorted list");
        System.out.println("sortByVoltage - to show example of sorted list");
        System.out.println("sortByPower - to show example of sorted list");
        System.out.println("sortByCountry - to show example of sorted list");
        System.out.println("sortByDate - to show example of sorted list");
        System.out.println("sortByEfficientClass - to show example of sorted list");
        System.out.println("findWithSize - to show founded record");
        System.out.println("findWithParameters -  to show founded record parameters:\n\t75 litres volume\n\tquiet ");
        System.out.println("countConsumedPower -  to show how much power consumed worked appliances");
        System.out.println("Good luck");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            controller.makeQuery(line);
        }

    }

    @Override
    public void outputInformation(String info) {
        System.out.println(info);
    }
}
