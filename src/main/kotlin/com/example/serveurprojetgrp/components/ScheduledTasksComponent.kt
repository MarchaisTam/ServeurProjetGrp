package com.example.serveurprojetgrp.components

import com.example.serveurprojetgrp.services.BikeContractService
import com.example.serveurprojetgrp.services.BikeStationService
import com.example.serveurprojetgrp.utils.tryNCatch
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasksComponent(
    val bikeStationService: BikeStationService,
    val bikeContractService: BikeContractService
) {

    @Scheduled(fixedRate = 60000)
    fun updateBikeStations() {
        println("update db: stations")
        bikeStationService.tryNCatch {
            deleteAllInDB()
            saveAllFromExtAPI()
        }
    }

//    @Scheduled(cron = "0 0 0 1 * *")
//    fun updateBikeContracts() {
//        println("update db: contracts")
//        bikeContractService.tryNCatch {
//            deleteAllInDB()
//            saveAllFromExtAPI()
//        }
//    }
}