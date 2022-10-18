package com.example.serveurprojetgrp

import com.example.serveurprojetgrp.beans.BikeStationBean
import com.example.serveurprojetgrp.services.BikeStationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class APIController(val bikeStationService: BikeStationService) {

    //http://2.4.228.11:8080/bike-stations
    @GetMapping("/bike-stations")
    fun getAllBikeStations(): List<BikeStationBean> {
        println("/bike-stations")
        return bikeStationService.findAllInDB()
    }

}