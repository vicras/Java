package com.company.model;

import com.company.model.homeelectricalappliances.EnergyEfficiencyClass;
import com.company.model.homeelectricalappliances.HomeElectricalAppliances;
import com.company.model.homeelectricalappliances.SizeType;
import com.company.model.homeelectricalappliances.parameters.Parameters;

import java.time.Period;
import java.util.List;
import java.util.Set;

public interface Taskable {
    /**
     * create list with random devices
     * @return list
     */
    List<HomeElectricalAppliances> createAppliance();

    /**
     * device consumed power only if it turn on
     * @param appliancesStream list of devices
     * @return sum of consumed power
     */
    long countConsumedPower(List<HomeElectricalAppliances> appliancesStream);

    /**
     * perform sort of list
     * @param list device list
     * @param parametersType sort by this param
     * @return sorted list by parametersType
     */
    public List<HomeElectricalAppliances> sortBy(List<HomeElectricalAppliances> list, ParametersType parametersType);

    /**
     * method perform finding by param
     * @param list list
     * @param type with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithSize(List<HomeElectricalAppliances> list, SizeType type);
    /**
     * method perform finding by param
     * @param list list
     * @param type with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithEnergyEf(List<HomeElectricalAppliances> list, EnergyEfficiencyClass type);
    /**
     * method perform finding by param
     * @param list list
     * @param power with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithPower(List<HomeElectricalAppliances> list, int power);
    /**
     * method perform finding by param
     * @param list list
     * @param voltage with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithVoltage(List<HomeElectricalAppliances> list, int voltage);
    /**
     * method perform finding by param
     * @param list list
     * @param country with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithCountry(List<HomeElectricalAppliances> list, String country);
    /**
     * method perform finding by param
     * @param list list
     * @param period with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findWithGuaranty(List<HomeElectricalAppliances> list, Period period);
    /**
     * method perform finding by param
     * @param list list
     * @param parameters with this param
     * @return devices which matched
     */
    public List<HomeElectricalAppliances> findByParameters(List<HomeElectricalAppliances> list, Set<Parameters> parameters);
}
