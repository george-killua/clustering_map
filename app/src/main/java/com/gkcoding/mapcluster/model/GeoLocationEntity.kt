package com.gkcoding.mapcluster.model

import kotlin.random.Random
import kotlin.random.asJavaRandom

fun generateDummyGeoLocations(): List<GeoLocation> {
    val locations = mutableListOf<GeoLocation>()
    val random = Random.asJavaRandom()

    for (i in 0 until 100) {
        val latitude = -90 + random.nextDouble() * 180 // Random latitude between -90 and 90
        val longitude = -180 + random.nextDouble() * 360 // Random longitude between -180 and 180
        locations.add(GeoLocation(latitude, longitude))
    }

    return locations
}
