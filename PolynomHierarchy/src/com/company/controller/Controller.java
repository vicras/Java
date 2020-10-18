package com.company.controller;

import com.company.model.Taskable;
import com.company.model.countable.Countable;
import com.company.model.countable.factory.ComplexNumberGenerator;
import com.company.model.countable.factory.RationalNumberGenerator;
import com.company.model.polynomial.Polynomial;
import com.company.view.ViewInterface;

import java.util.Arrays;

public class Controller implements Controlable {
    private final ViewInterface view;
    private final Taskable model;
    private final int POLYNOM_AND_RANK = 10;

    private PolynomType currentType = PolynomType.RATIO;

    public Controller(ViewInterface view, Taskable model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void init(){
        model.addListeners(view);
        view.init(this, model);

    }

    @Override
    public void makeQuery(String command) {
        command = command.trim();

        if (command.contains("doTask_")) {
            try {
                String[] strings = command.split("_");
                int length = Integer.parseInt(strings[1]);
                doTask(length);
            }catch (Exception ignored){}
        }else
        if (command.equals("showSubtract")) {
            showSubtract();
        }else
        if (command.equals("showMultiplication")) {
            showMultiplication();
        }else
        if (command.equals("setType(ratio)")) {
            setPolynomType(PolynomType.RATIO);
        }else
        if (command.equals("setType(complex)")) {
            setPolynomType(PolynomType.COMPLEX);
        } else {
            view.outputInformation("command words didn't found, try again");
        }
    }

    /**
     * perform task
     * @param length of polynom
     */
    public void doTask(int length) {
        try{
            Polynomial[] polynomArray = model.createPolynomArray(length, POLYNOM_AND_RANK, currentType.getType());
            view.outputInformation("Created polynom array");
            view.outputInformation(polynomArray);

            Polynomial ans = model.sumOfArray(polynomArray);
            view.outputInformation("Sum of created array");
            view.outputInformation(ans.toString());

        }catch (Exception e){
            view.outputInformation(Arrays.toString(e.getStackTrace()));
        }

    }

    /**
     * perform subtraction
     */
    public void showSubtract() {
        try {
            Polynomial[] polynomArray = model.createPolynomArray(2, POLYNOM_AND_RANK, currentType.getType());
            view.outputInformation("polynom #1:");
            view.outputInformation(polynomArray[0].toString());
            view.outputInformation("polynom #2:");
            view.outputInformation(polynomArray[1].toString());

            Polynomial ans = model.performSubtract(polynomArray);
            view.outputInformation("Subtract of created polynoms");

            view.outputInformation(ans.toString());

        }catch (Exception e){
            e.printStackTrace();
            view.outputInformation(Arrays.toString(e.getStackTrace()));
        }


    }

    /**
     * perform multiplication
     */
    public void showMultiplication() {
        try {
            Polynomial[] polynomArray = model.createPolynomArray(1, POLYNOM_AND_RANK, currentType.getType());

            view.outputInformation("polynom #1:");
            view.outputInformation(polynomArray[0].toString());

            String type = currentType == PolynomType.COMPLEX ?
                    ComplexNumberGenerator.class.getName() :
                    RationalNumberGenerator.class.getName();
            Countable countable = model.createCountable(type);

            view.outputInformation("Const:");
            view.outputInformation(countable.toString());

            Polynomial ans = model.performMultiplication(polynomArray[0], countable);
            view.outputInformation("Multiplication of created polynoms and constant number");

            view.outputInformation(ans.toString());

        }catch (Exception e){
            e.printStackTrace();
            view.outputInformation(Arrays.toString(e.getStackTrace()));
        }

    }

    /**
     * used to change polynom type
     * @param type
     */
    public void setPolynomType(PolynomType type) {
        currentType = type;
        view.outputInformation("polynom types was changed");
        view.outputInformation("current type: " + currentType);
    }
}
