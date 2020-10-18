package com.company.model;

import com.company.model.homeelectricalappliances.*;
import com.company.model.homeelectricalappliances.builder.*;
import com.company.model.homeelectricalappliances.light.Chandelier;
import com.company.model.homeelectricalappliances.light.Lamp;
import com.company.model.homeelectricalappliances.parameters.Parameters;
import com.company.model.homeelectricalappliances.states.WorkStates;

import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class TaskableImpl implements Taskable {


    @Override
    public List<HomeElectricalAppliances> createAppliance() {

        BuilderManager manager = new BuilderManager();
        ChandelierBuilder chandelierBuilder = new ChandelierBuilder();
        LampBuilder lampBuilder = new LampBuilder();
        FridgeBuilder fridgeBuilder = new FridgeBuilder();
        TVBuilder tvBuilder = new TVBuilder();

        manager.createAncientChandelier(chandelierBuilder);
        Chandelier chandelier = chandelierBuilder.getResult();

        manager.createTableLamp(lampBuilder);
        Lamp lamp = lampBuilder.getResult();

        manager.createAtlantFridge(fridgeBuilder);
        Fridge fridgeAtlant = fridgeBuilder.getResult();

        manager.createLGFridge(fridgeBuilder);
        Fridge fridgeLg = fridgeBuilder.getResult();
        fridgeAtlant.plugIn();
        fridgeAtlant.turnOn();

        manager.createSamsung20TV(tvBuilder);
        TV tv20 = tvBuilder.getResult();

        manager.createSamsung40TV(tvBuilder);
        TV tv40 = tvBuilder.getResult();

        manager.createSamsung60TV(tvBuilder);
        TV tv60 = tvBuilder.getResult();

        return Stream.of(chandelier, lamp, fridgeAtlant, fridgeLg, tv20, tv40, tv60)
                .peek((e) ->
                {
                    Random rnd = new Random();
                    if (rnd.nextBoolean()) {
                        e.plugIn();
                        if (rnd.nextBoolean()) {
                            e.turnOn();
                        }
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public long countConsumedPower(List<HomeElectricalAppliances> appliancesStream) {
        return appliancesStream.stream()
                .filter((e) -> e.getCurrentState() == WorkStates.WORKS)
                .mapToInt(HomeElectricalAppliances::getPower)
                .sum();
    }

    private List<HomeElectricalAppliances> findByParameters(Stream<HomeElectricalAppliances> stream, Predicate<HomeElectricalAppliances> predicate) {
        return stream
                .filter(predicate)
                .collect(Collectors.toList());

    }

    private List<HomeElectricalAppliances> sort(Stream<HomeElectricalAppliances> stream, Comparator<HomeElectricalAppliances> comparator){
        return stream.sorted(comparator).collect(Collectors.toList());
    }
    @Override
    public List<HomeElectricalAppliances> sortBy(List<HomeElectricalAppliances> list, ParametersType parametersType){
        var comp = comparing(HomeElectricalAppliances::getInventionDate);

        switch (parametersType){
            case VOLTAGE -> comp=comparing(HomeElectricalAppliances::getUsedVoltage);
            case POWER -> comp =comparing(HomeElectricalAppliances::getPower);
            case COUNTRY -> comp=comparing(HomeElectricalAppliances::getDevelopmentCountry);
            case DATE->comp=comparing(HomeElectricalAppliances::getInventionDate);
            case EFFICIENCY_CLASS->comp= Comparator.comparingInt(e -> e.getEnergyEfficiencyClass().getOrder());
            case SIZE_TYPE -> comp=Comparator.comparingInt(e -> e.getSizeType().getOrder());
        };
        return sort(list.stream(),comp);
    }
    @Override
    public List<HomeElectricalAppliances> findWithSize(List<HomeElectricalAppliances> list, SizeType type){
        return findByParameters(list.stream(), (e)->e.getSizeType().equals(type));
    }
    @Override
    public List<HomeElectricalAppliances> findWithEnergyEf(List<HomeElectricalAppliances> list, EnergyEfficiencyClass type){
        return findByParameters(list.stream(), (e)->e.getEnergyEfficiencyClass().equals(type));
    }
    @Override
    public List<HomeElectricalAppliances> findWithPower(List<HomeElectricalAppliances> list, int power){
        return findByParameters(list.stream(), (e)->e.getPower() == power);
    }

    @Override
    public List<HomeElectricalAppliances> findWithVoltage(List<HomeElectricalAppliances> list, int voltage){
        return findByParameters(list.stream(), (e)->e.getUsedVoltage() == voltage);
    }

    @Override
    public List<HomeElectricalAppliances> findWithCountry(List<HomeElectricalAppliances> list, String country){
        return findByParameters(list.stream(), (e)->e.getDevelopmentCountry().equals(country));
    }

    @Override
    public List<HomeElectricalAppliances> findWithGuaranty(List<HomeElectricalAppliances> list, Period period){
        return findByParameters(list.stream(), (e)->e.getGuarantyPeriod().equals(period));
    }

    @Override
    public List<HomeElectricalAppliances> findByParameters(List<HomeElectricalAppliances> list, Set<Parameters> parameters){
        return findByParameters(list.stream(), (e)->e.getParameters().equals(parameters));
    }
}
