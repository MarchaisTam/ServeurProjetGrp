package com.example.serveurprojetgrp.beans

import com.google.gson.annotations.SerializedName
import javax.persistence.Embeddable

@Embeddable
data class CoordBean(

    var lat: Double? = null,

    @SerializedName("lng")
    var lon: Double? = null

) {
    override fun toString(): String {
        return "(lat=$lat, lon=$lon)"
    }
}