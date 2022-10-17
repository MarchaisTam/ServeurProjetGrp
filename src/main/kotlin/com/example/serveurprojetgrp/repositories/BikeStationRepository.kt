package com.example.serveurprojetgrp.repositories

import com.example.serveurprojetgrp.beans.BikeStationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BikeStationRepository : JpaRepository<BikeStationEntity, Long> {

}