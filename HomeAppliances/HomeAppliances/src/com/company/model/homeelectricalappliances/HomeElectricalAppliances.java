package com.company.model.homeelectricalappliances;

import com.company.model.homeelectricalappliances.parameters.Parameters;
import com.company.model.homeelectricalappliances.states.StateObserver;
import com.company.model.homeelectricalappliances.states.StateProvider;
import com.company.model.homeelectricalappliances.states.StateProviderImpl;
import com.company.model.homeelectricalappliances.states.WorkStates;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Set;

public abstract class HomeElectricalAppliances {

    protected String name;
    protected String description;
    protected int power;
    protected int voltage;
    protected EnergyEfficiencyClass efficiencyClass;
    protected StateProvider stateProvider;
    protected LocalDate date;
    protected SizeType sizeType;
    protected Period guarantyPeriod;
    protected String country;
    protected Set<Parameters> parameters;

    /**
     *constructor home electrical appliances
     */
    protected HomeElectricalAppliances(String name, String description, int power, int voltage, EnergyEfficiencyClass efficiencyClass, LocalDate date, SizeType sizeType, Period guarantyPeriod, String country, Set<Parameters> parameters) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.voltage = voltage;
        this.efficiencyClass = efficiencyClass;
        this.stateProvider = new StateProviderImpl(this);
        this.date = date;
        this.sizeType = sizeType;
        this.guarantyPeriod = guarantyPeriod;
        this.country = country;
        this.parameters = parameters;
    }

    public int getVoltage() {
        return voltage;
    }

    public EnergyEfficiencyClass getEfficiencyClass() {
        return efficiencyClass;
    }

    public StateProvider getStateProvider() {
        return stateProvider;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    /**
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return power of device
     */
    public int getPower() {
        return power;
    }

    /**
     *
     * @return voltage
     */
    public int getUsedVoltage() {
        return voltage;
    }

    /**
     *
     * @return efficiency class
     */
    public EnergyEfficiencyClass getEnergyEfficiencyClass() {
        return efficiencyClass;
    }

    /**
     *
     * @return current state of electrical device
     */
    public WorkStates getCurrentState() {
        return stateProvider.getCurrentState();
    }

    /**
     * add new state observer, if state changed
     * observer will be notify
     * @param observer state observer
     */
    public void addStateObserver(StateObserver observer) {
        stateProvider.addStateObserver(observer);
    }

    /**
     * remove state observer, if it exist
     * @param observer obserrver
     */
    public void removeStateObserver(StateObserver observer) {
        stateProvider.removeStateObserver(observer);
    }

    /**
     * turn on electrical appliance
     * plug in device first
     */
    public void turnOn() {
        stateProvider.turnOn();
    }

    /**
     * turn off electrical appliance
     */
    public void turnOf() {
        stateProvider.turnOf();
    }

    /**
     * plug in device to electricity line
     */
    public void plugIn() {
        stateProvider.plugIn();
    }

    /**
     * plug out device from electricity line
     */
    public void plugOut() {
        stateProvider.turnOn();
    }

    /**
     *
     * @return day of production
     */
    public LocalDate getInventionDate() {
        return date;
    }

    /**
     *
     * @return size type of device
     */
    public SizeType getSizeType() {
        return sizeType;
    }

    /**
     *
     * @return guaranty period
     */
    public Period getGuarantyPeriod() {
        return guarantyPeriod;
    }

    /**
     *
     * @return development country
     */
    public String getDevelopmentCountry() {
        return country;
    }

    /**
     *
     * @return device parameters
     */
    public Set<Parameters> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "HomeElectricalAppliances:" +
                "\n*name: " + name + '\n' +
                "* description: " + description + '\n' +
                "* power: " + power + '\n' +
                "* voltage: " + voltage +'\n'+
                "* efficiencyClass: " + efficiencyClass + '\n' +
                "* state: " + stateProvider.getCurrentState()+ '\n' +
                "* date: " + date + '\n' +
                "* sizeType:" + sizeType + '\n' +
                "* guarantyPeriod:" + guarantyPeriod + '\n' +
                "* country: " + country + '\n' +
                "* parameters: " + parameters.stream().
        collect(StringBuilder::new,
                ((stringBuilder, string) -> stringBuilder.append("\n\t*").append(string.getName())),
                StringBuilder::append).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeElectricalAppliances that = (HomeElectricalAppliances) o;
        return power == that.power &&
                voltage == that.voltage &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                efficiencyClass == that.efficiencyClass &&
                Objects.equals(stateProvider, that.stateProvider) &&
                Objects.equals(date, that.date) &&
                sizeType == that.sizeType &&
                Objects.equals(guarantyPeriod, that.guarantyPeriod) &&
                Objects.equals(country, that.country) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, power, voltage, efficiencyClass, stateProvider, date, sizeType, guarantyPeriod, country, parameters);
    }
}
