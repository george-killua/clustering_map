package com.gkcoding.mapcluster.screens.clusterScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkcoding.mapcluster.data.locally.GeoLocationEntity
import com.gkcoding.mapcluster.repository.GeoLocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClusterViewModel
    @Inject
    constructor(private val geoLocationRepository: GeoLocationRepository) : ViewModel() {
        data class UiState(val geoLocations: List<GeoLocationEntity> = emptyList())

        private val uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
        val clusterUiState = uiState.asStateFlow()

        init {
            viewModelScope.launch {
                uiState.update { state ->
                    state.copy(geoLocations = geoLocationRepository.getGeoLocations())
                }
            }
        }
    }
