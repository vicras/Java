package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.light.Lamp;

public class LampBuilder extends LightBuilder {
    /**
     *
     * @return new Lamp
     */
    public Lamp getResult(){
        return new Lamp(name,description,power,voltage,efficiencyClass,date,sizeType,guarantyPeriod,country,parameters, lightType);
    }
}
