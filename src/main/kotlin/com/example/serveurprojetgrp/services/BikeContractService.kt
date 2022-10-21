package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.beans.BikeContractBean
import com.example.serveurprojetgrp.repositories.BikeContractRepository
import org.springframework.stereotype.Service

@Service
class BikeContractService(val bikeContractRepository: BikeContractRepository) {

    fun findAllInDB(): List<BikeContractBean> = bikeContractRepository.findAll()
    fun saveAllInDB(data: List<BikeContractBean>): List<BikeContractBean> = bikeContractRepository.saveAll(data)
    fun deleteAllInDB() = bikeContractRepository.deleteAll()

}