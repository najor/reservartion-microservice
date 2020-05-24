package com.reservation.client;

import com.reservation.model.Event;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "event-logger-service")//,url="http://localhost:8000/")
public interface EventLoggerClient {

    @PostMapping("/event")
    public void createEvent(@RequestBody Event newEvent);

}
