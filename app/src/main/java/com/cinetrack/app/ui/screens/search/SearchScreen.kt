package com.cinetrack.app.ui.screens.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cinetrack.app.CineTrackApp
import com.cinetrack.app.ui.components.*
import com.cinetrack.app.ui.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp
    
    val viewModel: SearchViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SearchViewModel(app.container.movieRepository, app.container.searchHistoryRepository) as T
            }
        }
    )

    val query by viewModel.searchQuery.collectAsState()
    val results by viewModel.searchResults.collectAsState()
    val recentSearches by viewModel.recentSearches.collectAsState()
    val genres by viewModel.genres.collectAsState()
    val filterOptions by viewModel.filterOptions.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    var searchActive by remember { mutableStateOf(false) }
    var showFilterSheet by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        SearchBarComponent(
            query = query,
            onQueryChange = viewModel::onQueryChange,
            onSearch = viewModel::onSearch,
            active = searchActive,
            onActiveChange = { searchActive = it },
            onFilterClick = { showFilterSheet = true },
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        ) {
            if (query.isEmpty() && recentSearches.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(recentSearches) { recentQuery ->
                        ListItem(
                            headlineContent = { Text(recentQuery) },
                            leadingContent = { Icon(Icons.Filled.History, contentDescription = null) },
                            modifier = Modifier.clickable {
                                viewModel.onQueryChange(recentQuery)
                                viewModel.onSearch(recentQuery)
                                searchActive = false
                            }
                        )
                    }
                }
            }
        }

        if (isLoading) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(6) {
                    MoviePosterShimmer(modifier = Modifier.fillMaxWidth(), width = 160, height = 240)
                }
            }
        } else if (results.isEmpty() && query.isNotEmpty()) {
            EmptyState(
                icon = Icons.Filled.SearchOff,
                title = "Nessun risultato",
                description = "Non abbiamo trovato film corrispondenti alla tua ricerca."
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(results, key = { it.id }) { movie ->
                    MoviePosterCard(
                        movie = movie,
                        onClick = { navController.navigate(Screen.Detail.createRoute(movie.id)) },
                        modifier = Modifier.fillMaxWidth(),
                        width = 160,
                        height = 240
                    )
                }
            }
        }
    }

    if (showFilterSheet) {
        FilterBottomSheet(
            genres = genres,
            currentFilters = filterOptions,
            onApplyFilters = viewModel::updateFilters,
            onDismiss = { showFilterSheet = false }
        )
    }
}
