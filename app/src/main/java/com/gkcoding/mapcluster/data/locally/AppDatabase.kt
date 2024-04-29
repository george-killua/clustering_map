package com.gkcoding.mapcluster.data.locally

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GeoLocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun geoLocationDao(): GeoLocationDao
}
