package com.company.model.homeelectricalappliances.light;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.HomeElectricalAppliances;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Set;

public abstract class LightElectricalAppliances extends HomeElectricalAppliances {

    final private LightType lightType;
    protected LightElectricalAppliances(String name, String description, int power, int voltage, EnergyEfficiencyClass efficiencyClass,
                                        LocalDate date, SizeType type, Period guarantyPeriod, String country,
                                        Set<Parameters> parameters, LightType lightType) {
        super(name, description, power, voltage, efficiencyClass, date, type, guarantyPeriod, country, parameters);
        this.lightType = lightType;
    }

    @Override
    public String toString() {
        String s = super.toString();

        return  s + "\n*lightType=" + lightType;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LightElectricalAppliances that = (LightElectricalAppliances) o;
        return lightType == that.lightType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lightType);
    }
}
