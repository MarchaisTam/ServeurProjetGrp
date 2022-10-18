package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.beans.BikeStationBean
import com.example.serveurprojetgrp.repositories.BikeStationRepository
import com.example.serveurprojetgrp.utils.RequestUtils
import org.springframework.stereotype.Service

@Service
class BikeStationService(val bikeStationRep: BikeStationRepository) {

    fun findAllInDB(): List<BikeStationBean> = bikeStationRep.findAll()
    fun saveAllFromExtAPI(): List<BikeStationBean> = bikeStationRep.saveAll(RequestUtils.loadBikeStations())
    fun deleteAllInDB() = bikeStationRep.deleteAll()

}