package com.gkcoding.mapcluster.data.locally

import androidx.room.Dao
import androidx.room.Query

@Dao
interface GeoLocationDao {
    @Query("SELECT * FROM geolocations")
    fun getAllGeoLocations(): List<GeoLocationEntity>
}
