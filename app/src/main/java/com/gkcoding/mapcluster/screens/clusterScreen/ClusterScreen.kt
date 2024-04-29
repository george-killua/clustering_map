package com.gkcoding.mapcluster.screens.clusterScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun ClusterScreen(clusterViewModel: ClusterViewModel) {
    val uiState = clusterViewModel.clusterUiState.collectAsState()
}
