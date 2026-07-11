package com.cinetrack.app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cinetrack.app.CineTrackApp
import com.cinetrack.app.ui.components.ErrorView
import com.cinetrack.app.ui.components.HorizontalMovieList
import com.cinetrack.app.ui.components.RatingBar
import com.cinetrack.app.ui.navigation.Screen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleFilled

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp
    
    val viewModel: HomeViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(app.container.movieRepository) as T
            }
        }
    )
    
    val uiState by viewModel.uiState.collectAsState()
    
    // Non-Material3 simple pull-to-refresh workaround or just manual reload button for now
    if (uiState.error != null && uiState.trending.isEmpty()) {
        ErrorView(
            message = uiState.error!!,
            onRetry = { viewModel.loadData(true) },
            modifier = modifier.fillMaxSize()
        )
        return
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Hero Banner (First Trending Movie)

        item {
            if (uiState.trending.isNotEmpty()) {
                val heroMovie = uiState.trending.first()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .clickable { navController.navigate(Screen.Detail.createRoute(heroMovie.id)) }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(heroMovie.backdropUrl ?: heroMovie.posterUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = heroMovie.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        MaterialTheme.colorScheme.background
                                    ),
                                    startY = 400f
                                )
                            )
                    )
		IconButton(
    		onClick = { navController.navigate(Screen.Reels.route) },
    		modifier = Modifier
        		.align(Alignment.TopEnd)
        		.padding(top = 40.dp, end = 16.dp)
        		.background(Color.Black.copy(alpha = 0.4f), shape = MaterialTheme.shapes.extraLarge)
		) {
    		Icon(Icons.Filled.PlayCircleFilled, contentDescription = "Reels", tint = Color.White)
		}
                    
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(24.dp)
                    ) {
                        Text(
                            text = heroMovie.title,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                                           }
                }
            } else if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )
            }
        }

        val onMovieClick = { id: Int -> navController.navigate(Screen.Detail.createRoute(id)) }

        item {
            HorizontalMovieList(
                title = "Trending Oggi",
                movies = uiState.trending.drop(1), // Skip the hero movie
                isLoading = uiState.isLoading,
                onMovieClick = onMovieClick
            )
        }

        item {
            HorizontalMovieList(
                title = "Film Popolari",
                movies = uiState.popular,
                isLoading = uiState.isLoading,
                onMovieClick = onMovieClick
            )
        }

        item {
            HorizontalMovieList(
                title = "In Sala",
                movies = uiState.nowPlaying,
                isLoading = uiState.isLoading,
                onMovieClick = onMovieClick
            )
        }

        item {
            HorizontalMovieList(
                title = "Prossimamente",
                movies = uiState.upcoming,
                isLoading = uiState.isLoading,
                onMovieClick = onMovieClick
            )
        }

        item {
            HorizontalMovieList(
                title = "I Più Votati",
                movies = uiState.topRated,
                isLoading = uiState.isLoading,
                onMovieClick = onMovieClick
            )
        }
    }
}
