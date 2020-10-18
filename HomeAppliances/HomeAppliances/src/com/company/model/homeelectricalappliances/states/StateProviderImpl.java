package com.company.model.homeelectricalappliances.states;

import com.company.model.homeelectricalappliances.HomeElectricalAppliances;

import java.util.ArrayList;
import java.util.List;

public class StateProviderImpl implements StateProvider{

    HomeElectricalAppliances device;

    ApplianceState current;
    Works worksState;
    ConnectedToPower connectionToPower;
    Deenergization deenergizationState;

    List<StateObserver> observers;

    public StateProviderImpl(HomeElectricalAppliances device) {
        this.device = device;

        observers = new ArrayList<>();
        worksState =new Works(this);
        connectionToPower =new ConnectedToPower(this);
        deenergizationState = new Deenergization(this);
        current = deenergizationState;
    }

    @Override
    public void setCurrentState(ApplianceState state) {
        current = state;
    }

    @Override
    public WorkStates getCurrentState() {
        return current.getState();
    }

    @Override
    public ConnectedToPower getConnectedToPowerState() {
        return connectionToPower;
    }

    @Override
    public Deenergization getDeenergizationState() {
        return deenergizationState;
    }

    @Override
    public Works getWorksState() {
        return worksState;
    }

    @Override
    public void turnOn() {
        current.turnOn();
    }

    @Override
    public void turnOf() {
        current.turnOff();
    }

    @Override
    public void plugIn() {
        current.plugIn();
    }

    @Override
    public void plugOut() {
        current.plugOut();
    }

    @Override
    public void addStateObserver(StateObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeStateObserver(StateObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((e)-> e.StateChanged(current));
    }

    @Override
    public String toString() {
        return current.getState().toString();
    }
}
