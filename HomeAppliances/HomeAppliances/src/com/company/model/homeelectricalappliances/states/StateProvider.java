package com.company.model.homeelectricalappliances.states;

public interface StateProvider {
    void setCurrentState(ApplianceState state);
    WorkStates getCurrentState();
    ConnectedToPower getConnectedToPowerState();
    Deenergization getDeenergizationState();
    Works getWorksState();

    void turnOn();
    void turnOf();

    void plugIn();
    void plugOut();


    void addStateObserver(StateObserver observer);
    void removeStateObserver(StateObserver observer);
    void notifyObservers();
}
