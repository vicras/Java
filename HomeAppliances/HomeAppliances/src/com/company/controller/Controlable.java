package com.company.controller;

public interface Controlable {
    /**
     * execute query
     * @param command command which need to execute
     */
    void makeQuery(String command);

    /**
     * init controller
     */
    void init();
}
