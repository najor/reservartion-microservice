package com.reservation.model;

import java.util.List;

public class Reservation {

    private String id;
    private String name;
    private List<String> tables;

    public Reservation(String id, String name, List<String> tables) {
        this.id = id;
        this.name = name;
        this.tables = tables;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTables() {
        return tables;
    }
}
