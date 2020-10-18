package com.company.view;

import com.company.controller.Controlable;
import com.company.model.Taskable;
import com.company.model.polynomial.Polynomial;

import java.util.Scanner;

public class ConsoleOutputer implements ViewInterface {

    Thread thread;
    Controlable controller;
    Taskable model;


    public ConsoleOutputer() {
    }


    void gui() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to lab01 representer ");
        System.out.println("Graskov Viktor 2020 all rights reserved ");
        System.out.println("use this command words:");
        System.out.println("doTask_m - to show sum of polynom array, were m is array length");
        System.out.println("showSubtract - to show subtract of two polynoms");
        System.out.println("showMultiplication - to show multiplications of two polynom ans const");
        System.out.println("setType([ratio|complex]) - to set type of polynoms (ratio is default)");
        System.out.println("Good luck");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            controller.makeQuery(line);
        }

    }

    @Override
    public void init(Controlable controller, Taskable task) {
        this.controller = controller;
        this.model = task;

        thread = new Thread(this::gui);
        thread.start();
    }

    @Override
    public void update() {
        System.out.println("#View: some information from model");
    }

    @Override
    public void outputInformation(Polynomial[] polynomial) {
        for(var i : polynomial)
            System.out.println(i);
    }

    @Override
    public void outputInformation(String info) {
        System.out.println(info);
    }
}
