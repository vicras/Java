package com.company.model.homeelectricalappliances.states;

public class Deenergization implements ApplianceState {
    private final StateProvider device;

    public Deenergization(StateProvider device) {
        this.device = device;
    }

    @Override
    public void turnOff() {
        System.out.println("device has already turned off");
    }

    @Override
    public void turnOn() {
        System.out.println("device hasn't had electricity connection");
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
        return WorkStates.DEENEGRIZATION;
    }
}
