package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.beans.BikeStationBean
import com.example.serveurprojetgrp.repositories.BikeStationRepository
import org.springframework.stereotype.Service

@Service
class BikeStationService(val bikeStationRep: BikeStationRepository) {

    fun findAllInDB(): List<BikeStationBean> = bikeStationRep.findAll()
    fun saveAllInDB(data: List<BikeStationBean>): List<BikeStationBean> = bikeStationRep.saveAll(data)
    fun deleteAllInDB() = bikeStationRep.deleteAll()

}