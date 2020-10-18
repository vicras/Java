package com.company.view;

import com.company.controller.Controlable;
import com.company.model.TaskObserver;
import com.company.model.Taskable;
import com.company.model.polynomial.Polynomial;

public interface ViewInterface extends TaskObserver {
    void init(Controlable controller, Taskable task);
    void outputInformation(Polynomial[] polynomial);
    void outputInformation(String info);
}
