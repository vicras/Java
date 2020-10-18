package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public abstract class Builder {
    protected String name;

    protected String description;
    protected int power;
    protected int voltage;
    protected EnergyEfficiencyClass efficiencyClass;
    protected LocalDate date;
    protected SizeType sizeType;
    protected Period guarantyPeriod;
    protected String country;
    protected Set<Parameters> parameters;

    /**
     * set description of new device
     * @param description string description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set power of new device
     * @param power int description
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * set voltage of new device
     * @param voltage int description
     */
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    /**
     * set energy class of new device
     * @param efficiencyClass EnergyEfficiencyClass description
     */
    public void setEfficiencyClass(EnergyEfficiencyClass efficiencyClass) {
        this.efficiencyClass = efficiencyClass;
    }

    /**
     * set date of invention of new device
     * @param date LocalDate description
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * set size of new device
     * @param sizeType SizeType description
     */
    public void setSizeType(SizeType sizeType) {
        this.sizeType = sizeType;
    }

    /**
     * set guarantyPeriod of new device
     * @param guarantyPeriod Period description
     */
    public void setGuarantyPeriod(Period guarantyPeriod) {
        this.guarantyPeriod = guarantyPeriod;
    }

    /**
     * set country of new device
     * @param country string description
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * set parameters of new device
     * @param parameters param set
     */
    public void setParameters(Set<Parameters> parameters) {
        this.parameters = parameters;
    }

    /**
     * set description of new device
     * @param name string description
     */
    public void setName(String name) {
        this.name = name;
    }

}
