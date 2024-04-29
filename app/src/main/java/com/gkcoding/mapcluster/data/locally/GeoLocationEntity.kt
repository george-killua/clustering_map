package com.gkcoding.mapcluster.data.locally

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geolocations")
data class GeoLocationEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val latitude: Double,
    val longitude: Double,
)
