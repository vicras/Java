package com.company.model.homeelectricalappliances.light;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class Lamp extends LightElectricalAppliances {
    /**
     *lamp constructor
     */
    public Lamp(String name, String description, int power, int voltage, EnergyEfficiencyClass efficiencyClass, LocalDate date, SizeType type, Period guarantyPeriod, String country, Set<Parameters> parameters, LightType lightType) {
        super(name, description, power, voltage, efficiencyClass, date, type, guarantyPeriod, country, parameters, lightType);
    }

    @Override
    public String toString() {
        return "\nLamp:\n " + super.toString();
    }
}
