package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.light.LightType;
import com.company.model.homeelectricalappliances.parameters.Parameters;
import com.company.model.homeelectricalappliances.states.StateProvider;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public abstract class LightBuilder {

    LightType lightType;
    protected String name;
    protected String description;
    protected int power;
    protected int voltage;
    protected EnergyEfficiencyClass efficiencyClass;
    protected StateProvider stateProvider;
    protected LocalDate date;
    protected SizeType sizeType;
    protected Period guarantyPeriod;
    protected String country;
    protected Set<Parameters> parameters;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public void setEfficiencyClass(EnergyEfficiencyClass efficiencyClass) {
        this.efficiencyClass = efficiencyClass;
    }

    public void setStateProvider(StateProvider stateProvider) {
        this.stateProvider = stateProvider;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }

    public void setGuarantyPeriod(Period guarantyPeriod) {
        this.guarantyPeriod = guarantyPeriod;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setParameters(Set<Parameters> parameters) {
        this.parameters = parameters;
    }
    public void setLightType(LightType lightType) {
        this.lightType = lightType;
    }

    public void setName(String name) {
        this.name = name;
    }
}
