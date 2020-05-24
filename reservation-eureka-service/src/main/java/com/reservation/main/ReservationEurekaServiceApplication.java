package com.reservation.main;

import com.reservation.client.EventLoggerClient;
import com.reservation.controller.ReservationController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ReservationController.class)
@EnableFeignClients(basePackageClasses = EventLoggerClient.class)
@EnableEurekaClient

public class ReservationEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationEurekaServiceApplication.class, args);
    }

}
