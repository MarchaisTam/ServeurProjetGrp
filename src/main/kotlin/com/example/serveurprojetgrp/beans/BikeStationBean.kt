package com.example.serveurprojetgrp.beans

import com.google.gson.annotations.SerializedName
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "bike_station")
data class BikeStationEntity(

    var name: String = "",
    var address: String = "",

    @Embedded
    var position: CoordBean? = null,

    var banking: Boolean? = null,

    @SerializedName("bike_stands")
    var stands: Int? = null,
    @SerializedName("available_bike_stands")
    var availableStands: Int? = null,
    @SerializedName("available_bikes")
    var availableBikes: Int? = null,

    var status: String = "",

    @SerializedName("last_update")
    var lastUpdate: Long? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as BikeStationEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(name = $name , address = $address , position = $position, banking = $banking , availableStands = $availableStands , availableBikes = $availableBikes , status = $status )"
    }

}