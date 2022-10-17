package com.example.serveurprojetgrp.beans

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
    var stands: Int? = null,
    var availableStands: Int? = null,
    var availableBikes: Int? = null,
    var status: String = "",
    var lastUpdate: Long? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

) {

    fun toBean() = BikeStationBean(
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