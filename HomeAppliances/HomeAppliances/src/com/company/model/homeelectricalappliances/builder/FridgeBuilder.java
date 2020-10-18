package com.company.model.homeelectricalappliances.builder;

import com.company.model.homeelectricalappliances.Fridge;

public class FridgeBuilder extends Builder {
    /**
     *
     * @return new Fridge
     */
    public Fridge getResult(){
        return new Fridge(name,description,power,voltage,efficiencyClass,date,sizeType,guarantyPeriod,country,parameters);
    }
}
