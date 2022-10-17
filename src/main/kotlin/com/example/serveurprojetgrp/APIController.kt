package com.example.serveurprojetgrp

import com.example.serveurprojetgrp.beans.BikeStationBean
import com.example.serveurprojetgrp.services.BikeStationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class APIController(val bikeStationService: BikeStationService) {

    //http://localhost:8080/filter
    @GetMapping("/filter")
    fun filter(): List<BikeStationBean> {
        println("/filter")
        return bikeStationService.getAll()
    }

    //http://localhost:8080/save
    @GetMapping("/save")
    fun save() {
        println("/save")
        bikeStationService.saveAll()
    }

    //http://localhost:8080/delete
    @GetMapping("/delete")
    fun delete() {
        println("/delete")
        bikeStationService.deleteAll()
    }

}