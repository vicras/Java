package com.company.model.homeelectricalappliances.states;

public class Works implements ApplianceState {
    private final StateProvider device;

    public Works(StateProvider device) {
        this.device = device;
    }

    @Override
    public void turnOff() {
        device.setCurrentState(device.getConnectedToPowerState());
        device.notifyObservers();
    }

    @Override
    public void turnOn() {
        System.out.println("device has already turned on");
    }

    @Override
    public void plugIn() {
        System.out.println("device has already plugged in");
    }

    @Override
    public void plugOut() {
        device.setCurrentState(device.getDeenergizationState());
        device.notifyObservers();
    }

    @Override
    public WorkStates getState() {
        return WorkStates.WORKS;
    }
}
