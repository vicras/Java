package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.light.Chandelier;

public class ChandelierBuilder extends LightBuilder {

    /**
     *
     * @return new Chandelier
     */
    public Chandelier getResult(){
        return new Chandelier(name,description,power,voltage,efficiencyClass,date,sizeType,guarantyPeriod,country,parameters, lightType);
    }
}
