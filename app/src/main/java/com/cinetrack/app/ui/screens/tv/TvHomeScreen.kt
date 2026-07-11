package com.cinetrack.app.ui.screens.tv

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cinetrack.app.CineTrackApp
import com.cinetrack.app.ui.components.ErrorView
import com.cinetrack.app.ui.components.HorizontalTvList
import com.cinetrack.app.ui.navigation.Screen

@Composable
fun TvHomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val app = context.applicationContext as CineTrackApp

    val viewModel: TvHomeViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TvHomeViewModel(app.container.tvShowRepository) as T
            }
        }
    )

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.error != null && uiState.trending.isEmpty()) {
        ErrorView(
            message = uiState.error!!,
            onRetry = { viewModel.loadData() },
            modifier = modifier.fillMaxSize()
        )
        return
    }

    val onTvClick = { id: Int -> navController.navigate(Screen.TvDetail.createRoute(id)) }

    LazyColumn(modifier = modifier.fillMaxSize(), contentPadding =PaddingValues(bottom = 24.dp)) {
        item {
            HorizontalTvList("Di Tendenza", uiState.trending, uiState.isLoading, onTvClick)
        }
        item {
            HorizontalTvList("In Onda", uiState.onTheAir, uiState.isLoading, onTvClick)
        }
        item {
            HorizontalTvList("Popolari", uiState.popular, uiState.isLoading, onTvClick)
        }
        item {
            HorizontalTvList("Più Votate", uiState.topRated, uiState.isLoading, onTvClick)
        }
    }
}
