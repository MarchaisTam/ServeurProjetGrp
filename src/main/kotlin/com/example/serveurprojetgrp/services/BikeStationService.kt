package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.repositories.BikeStationRepository
import com.example.serveurprojetgrp.utils.RequestUtils
import org.springframework.stereotype.Service

@Service
class BikeStationService(val bikeStationRep: BikeStationRepository) {

    fun getAll() = bikeStationRep.findAll()

    fun saveAll() = bikeStationRep.saveAll(RequestUtils.loadBikeStations().map { it.toEntity() })

    fun deleteAll() = bikeStationRep.deleteAll()

}