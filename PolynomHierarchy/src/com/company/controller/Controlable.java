package com.company.controller;

public interface Controlable {
    /**
     *
     * @param command new command to controller
     */
    void makeQuery(String command);

    /**
     * initialization of controller
     */
    void init();
}
