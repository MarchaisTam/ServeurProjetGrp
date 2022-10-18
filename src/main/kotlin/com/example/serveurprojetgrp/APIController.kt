package com.example.serveurprojetgrp

import com.example.serveurprojetgrp.constants.DBREQUEST_ERROR
import com.example.serveurprojetgrp.services.BikeStationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class APIController(val bikeStationService: BikeStationService) {

    //http://2.4.228.11:8080/bike-stations
    @GetMapping("/bike-stations")
    fun getAllBikeStations(response: HttpServletResponse): Any {
        println("/bike-stations")
        return try {
            bikeStationService.findAllInDB()
        } catch (e: Exception) {
            e.printStackTrace()
            response.status = DBREQUEST_ERROR
            e
        }
    }

}