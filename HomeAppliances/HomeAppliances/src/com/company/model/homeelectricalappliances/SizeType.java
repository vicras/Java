package com.company.model.homeelectricalappliances;

public enum SizeType implements Comparable<SizeType>{
    LOW(0),
    MEDIUM(1),
    BIG(2),
    HUGE(3);

    private int order;

    SizeType(int order) {
        this.order = order;
    }

    /**
     * order of enum elements
     * @return number
     */
    public int getOrder() {
        return order;
    }
}
