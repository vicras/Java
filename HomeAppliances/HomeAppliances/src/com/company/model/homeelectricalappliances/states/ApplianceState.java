package com.company.model.homeelectricalappliances.states;

public interface ApplianceState {
    void turnOff();
    void turnOn();
    void plugIn();
    void plugOut();
    WorkStates getState();

}
