package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.repositories.BikeStationRepository
import com.example.serveurprojetgrp.utils.RequestUtils
import org.springframework.stereotype.Service

@Service
class BikeStationService(val bikeStationRep: BikeStationRepository) {

    fun findAllInDB() = bikeStationRep.findAll()
    fun saveAllFromExtAPI() = bikeStationRep.saveAll(RequestUtils.loadBikeStations())
    fun deleteAllInDB() = bikeStationRep.deleteAll()

}