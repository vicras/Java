package com.company.model.homeelectricalappliances;

import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class TV extends HomeElectricalAppliances {

    /**
     *TV constructor
     */
    public TV(String name, String description, int power, int voltage, EnergyEfficiencyClass efficiencyClass, LocalDate date, SizeType type, Period guarantyPeriod, String country, Set<Parameters> parameters) {
        super(name, description, power, voltage, efficiencyClass, date, type, guarantyPeriod, country, parameters);
    }

    /**
     * To String overriding
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "\nTV:\n " + super.toString();
    }
}
