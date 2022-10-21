package com.example.serveurprojetgrp

import com.example.serveurprojetgrp.services.BikeContractService
import com.example.serveurprojetgrp.services.BikeStationService
import com.example.serveurprojetgrp.utils.RequestUtils
import com.example.serveurprojetgrp.utils.tryNCatch
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class APIController(val bikeStationService: BikeStationService, val bikeContractService: BikeContractService) :
    ErrorController {

    //http://2.4.228.11:8080/bike-stations
    @GetMapping("/bike-stations")
    fun getAllBikeStations(response: HttpServletResponse, request: HttpServletRequest): Any {
        println("/bike-stations from ${RequestUtils.getClientIpAddress(request)}")
        return bikeStationService.tryNCatch(response) {
            findAllInDB()
        }
    }

//    //http://2.4.228.11:8080/bike-contracts
//    @GetMapping("/bike-contracts")
//    fun getAllBikeContracts(response: HttpServletResponse): Any {
//        println("/bike-contracts")
//        return bikeContractService.tryNCatch(response) {
//            findAllInDB()
//        }
//    }

    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest): Any {
        val route = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI)
        val code = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        println("/error from $route - ${RequestUtils.getClientIpAddress(request)}")
        return object {
            val error_code = runCatching { code as Int }.getOrDefault(404)
            val error_message = HttpStatus.resolve(error_code)?.reasonPhrase ?: "Unknown Error"
        }
    }
}