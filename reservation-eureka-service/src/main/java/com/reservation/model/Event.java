package com.reservation.model;

public class Event {

    private String type;
    private String reservationId;
    private String name;

    public Event() {
    }

    public Event(String type, String reservationId, String name) {
        this.type = type;
        this.reservationId = reservationId;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
