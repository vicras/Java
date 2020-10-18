package com.company.model.homeelectricalappliances;

import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class Fridge extends HomeElectricalAppliances {

    /**
     *fridge constructor
     */
    public Fridge(String name, String description, int power, int voltage, EnergyEfficiencyClass efficiencyClass, LocalDate date, SizeType type, Period guarantyPeriod, String country, Set<Parameters> parameters) {
        super(name, description, power, voltage, efficiencyClass, date, type, guarantyPeriod, country, parameters);
    }

    @Override
    public String toString() {
        return "\nFridge:\n " + super.toString();
    }
}
