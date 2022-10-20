package com.example.serveurprojetgrp.beans

data class BikeContractBean(

    var name: String = "",
    var cities: List<String>? = null,
    var countryCode: String = "",
    var id: Long? = null

)