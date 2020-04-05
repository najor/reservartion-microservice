package com.reservation.reservation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer


@SpringBootApplication
@EnableEurekaServer
class ReservationEurekaServerApplication

fun main(args: Array<String>) {
    runApplication<ReservationEurekaServerApplication>(*args)
}
