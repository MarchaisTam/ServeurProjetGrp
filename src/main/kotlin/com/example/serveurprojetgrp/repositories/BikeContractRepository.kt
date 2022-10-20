package com.example.serveurprojetgrp.repositories

import com.example.serveurprojetgrp.beans.BikeContractBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BikeContractRepository : JpaRepository<BikeContractBean, Long>