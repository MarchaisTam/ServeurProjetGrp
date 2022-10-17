package com.example.serveurprojetgrp.beans

import com.google.gson.annotations.SerializedName

data class BikeStationBean(

    var name: String,
    var address: String,
    var position: CoordBean?,
    var banking: Boolean?,

    @SerializedName("bike_stands")
    var stands: Int?,
    @SerializedName("available_bike_stands")
    var availableStands: Int?,
    @SerializedName("available_bikes")
    var availableBikes: Int?,

    var status: String,

    @SerializedName("last_update")
    var lastUpdate: Long?

) {

    fun hasAvailableStands() = availableStands!! > 0

    fun hasAvailableBikes() = availableBikes!! > 0

    fun toEntity() = BikeStationEntity(
        name,
        address,
        position,
        banking,
        stands,
        availableStands,
        availableBikes,
        status,
        lastUpdate
    )

    override fun toString(): String {
        return "name='$name', address='$address', banking=$banking, availableStands=$availableStands, availableBikes=$availableBikes, status='$status'"
    }

}