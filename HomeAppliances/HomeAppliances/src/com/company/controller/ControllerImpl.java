package com.company.controller;

import com.company.model.ParametersType;
import com.company.model.Taskable;
import com.company.model.homeelectricalappliances.HomeElectricalAppliances;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.parameters.DefaultParameter;
import com.company.model.homeelectricalappliances.parameters.Parameters;
import com.company.view.ViewInterface;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerImpl implements Controlable {
    Taskable model;
    ViewInterface view;
    List<HomeElectricalAppliances> list;

    public ControllerImpl(Taskable model, ViewInterface view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void makeQuery(String command) {
        command = command.trim();

        if (command.contains("getList")) {
            getList();
        } else if (list ==null) {
            view.outputInformation("execute getLIst first");
        } else if (command.equals("sortBySize")) {
           sortBySize();
        } else if (command.equals("sortByVoltage")) {
            sortByVoltage();
        } else if (command.equals("sortByPower")) {
           sortByPower();
        } else if (command.equals("sortByDate")) {
            sortByDate();
        } else if (command.equals("sortByCountry")) {
            sortByCountry();
        } else if (command.equals("sortByEfficientClass")) {
            sortByEfficientClass();
        } else if (command.equals("findWithSize")) {
            findWithSize();
        } else if (command.equals("findWithParameters")) {
            findWithParameters();
        } else if (command.equals("countConsumedPower")) {
            countConsumedPower();
        } else {
            view.outputInformation("command words didn't found, try again");
        }
    }

    @Override
    public void init() {
        view.init(this, model);
    }

    /**
     * command getList
     */
    public void getList() {
        list = model.createAppliance();
        view.outputInformation(list.toString());
    }
    /**
     * command sortBySize
     */
    public void sortBySize() {
        view.outputInformation(model.sortBy(list, ParametersType.SIZE_TYPE).toString());
    }
    /**
     * command sortByVoltage
     */
    public void sortByVoltage() {
        view.outputInformation(model.sortBy(list, ParametersType.VOLTAGE).toString());
    }
    /**
     * command sortByPower
     */
    public void sortByPower() {
        view.outputInformation(model.sortBy(list, ParametersType.POWER).toString());
    }
    /**
     * command sortByCountry
     */
    public void sortByCountry() {
        view.outputInformation(model.sortBy(list, ParametersType.COUNTRY).toString());
    }
    /**
     * command sortByDate
     */
    public void sortByDate() {
        view.outputInformation(model.sortBy(list, ParametersType.DATE).toString());
    }
    /**
     * command sortByEfficientClass
     */
    public void sortByEfficientClass() {
        view.outputInformation(model.sortBy(list, ParametersType.EFFICIENCY_CLASS).toString());
    }
    /**
     * command findWithSize
     */
    public void findWithSize() {
        view.outputInformation(model.findWithSize(list, SizeType.HUGE).toString());
    }
    /**
     * command findWithParameters
     */
    public void findWithParameters() {
        Set<Parameters> parameters = Stream.of(
                new DefaultParameter("75 litres volume"),
                new DefaultParameter("quiet")
        )
                .collect(Collectors.toSet());
        view.outputInformation(model.findByParameters(list, parameters).toString());
    }

    /**
     * command countConsumedPower
     */
    public void countConsumedPower() {
        view.outputInformation(String.valueOf(model.countConsumedPower(list)));
    }
}
