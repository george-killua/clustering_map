package com.gkcoding.mapcluster.repository

import com.gkcoding.mapcluster.data.locally.GeoLocationDao
import com.gkcoding.mapcluster.data.locally.GeoLocationEntity
import javax.inject.Inject

class
GeoLocationRepositoryImpl@Inject
    constructor(private val geoLocationDao: GeoLocationDao) : GeoLocationRepository {
        override suspend fun getGeoLocations(): List<GeoLocationEntity> {
            return geoLocationDao.getAllGeoLocations()
        }
    }

interface GeoLocationRepository {
    suspend fun getGeoLocations(): List<GeoLocationEntity>
}
