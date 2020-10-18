package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.TV;

public class TVBuilder extends Builder{

    /**
     *
     * @return new TV
     */
    public TV getResult(){
        return new TV(name,description,power,voltage,efficiencyClass,date,sizeType,guarantyPeriod,country,parameters);
    }
}
