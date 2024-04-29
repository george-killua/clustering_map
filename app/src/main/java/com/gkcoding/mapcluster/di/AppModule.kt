package com.gkcoding.mapcluster.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gkcoding.mapcluster.data.locally.AppDatabase
import com.gkcoding.mapcluster.data.locally.GeoLocationDao
import com.gkcoding.mapcluster.data.locally.GeoLocationEntity
import com.gkcoding.mapcluster.model.generateDummyGeoLocations
import com.gkcoding.mapcluster.repository.GeoLocationRepository
import com.gkcoding.mapcluster.repository.GeoLocationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(
    SingletonComponent::class,
)
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "appDatabase")
            .allowMainThreadQueries()
            .addCallback(
                object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // Generate and insert dummy GeoLocation data on database creation
                        val geoLocations =
                            generateDummyGeoLocations() // Generate dummy GeoLocations
                        val geoLocationEntities =
                            geoLocations.map { location ->
                                GeoLocationEntity(
                                    latitude = location.latitude,
                                    longitude = location.longitude,
                                )
                            }

                        db.execSQL(
                            "INSERT INTO geolocations (latitude, longitude) VALUES (?, ?)",
                            geoLocationEntities.map { arrayOf(it.latitude, it.longitude) }
                                .toTypedArray(),
                        )
                    }
                },
            ).build()

    @Provides
    fun providesGeoLocationDao(postDatabase: AppDatabase): GeoLocationDao = postDatabase.geoLocationDao()

    @Provides
    fun providesGeoLocationRepository(geoLocationDao: GeoLocationDao): GeoLocationRepository = GeoLocationRepositoryImpl(geoLocationDao)
}
