package com.example.serveurprojetgrp.services

import com.example.serveurprojetgrp.beans.BikeContractBean
import com.example.serveurprojetgrp.repositories.BikeContractRepository
import com.example.serveurprojetgrp.utils.RequestUtils
import org.springframework.stereotype.Service

@Service
class BikeContractService(val bikeContractRepository: BikeContractRepository) {

    fun findAllInDB(): List<BikeContractBean> = bikeContractRepository.findAll()
    fun saveAllFromExtAPI(): List<BikeContractBean> = bikeContractRepository.saveAll(RequestUtils.loadBikeContracts())
    fun deleteAllInDB() = bikeContractRepository.deleteAll()
    
}