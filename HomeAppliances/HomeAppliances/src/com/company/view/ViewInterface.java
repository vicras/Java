package com.company.view;

import com.company.controller.Controlable;
import com.company.model.Taskable;

public interface ViewInterface {
        /**
         * init view
         * @param controller controller
         * @param task model
         */
        void init(Controlable controller, Taskable task);

        /**
         * method called to output String information by using view
         * @param info info to output
         */
        void outputInformation(String info);

}
