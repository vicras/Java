package com.company.model.homeelectricalappliances.states;

public class ConnectedToPower implements ApplianceState{
    private final StateProvider device;

    public ConnectedToPower(StateProvider device) {
        this.device = device;
    }

    @Override
    public void turnOff() {
        System.out.println("device has already turned off");
    }

    @Override
    public void turnOn() {
        device.setCurrentState(device.getWorksState());
        device.notifyObservers();
    }

    @Override
    public void plugIn() {
        device.setCurrentState(device.getConnectedToPowerState());
        device.notifyObservers();
    }

    @Override
    public void plugOut() {
        System.out.println("device has already plugged out");
    }

    @Override
    public WorkStates getState() {
        return WorkStates.CONNECTED_TO_POWER;
    }
}
