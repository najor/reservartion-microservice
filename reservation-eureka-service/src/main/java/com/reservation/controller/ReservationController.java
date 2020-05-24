package com.reservation.controller;

import com.reservation.client.EventLoggerClient;
import com.reservation.model.Event;
import com.reservation.model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class ReservationController {

    @Value("${server.port}")
    private String portNumber;

    @Autowired
    private EventLoggerClient eventLoggerClient;

    @GetMapping("/actuator/info")
    public String actuatorInfo() {
        return "I am alive in port:" + portNumber;
    }

    @GetMapping("/status")
    public String status() {
        return "I am alive in port:" + portNumber;
    }

    @PostMapping("/reservation")
    public String newEvent(@RequestBody Reservation reservation) {
        reservation.setId(UUID.randomUUID().toString());
        String tables = reservation.getTables().stream().reduce("", (s, s2) -> s + ", table[" + s2 + "]");
        eventLoggerClient.createEvent(new Event("NEW", reservation.getId(), tables));

        return "Created new event in event-logger-microservice";
    }

}
