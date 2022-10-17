package com.example.serveurprojetgrp.components

import com.example.serveurprojetgrp.services.BikeStationService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasksComponent(val bikeStationService: BikeStationService) {

    @Scheduled(fixedRate = 60000)
    fun updateDatabase() {
        bikeStationService.deleteAll()
        bikeStationService.saveAll()
        println("update db")
    }
}