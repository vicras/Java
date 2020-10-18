package com.company.model.homeelectricalappliances;

public enum EnergyEfficiencyClass {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6);

    private int order;

    EnergyEfficiencyClass(int order) {
        this.order = order;
    }

    /**
     *
     * @return order of Energy efficiency class to sort by comparator
     */
    public int getOrder() {
        return order;
    }
}
