package com.cinetrack.app.ui.screens.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
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
import com.cinetrack.app.ui.components.*
import com.cinetrack.app.ui.navigation.Screen
import com.cinetrack.app.ui.util.formatVoteCount

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
    movieId: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp

    val viewModel: DetailViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel(
                    movieId,
                    app.container.movieRepository,
                    app.container.watchlistRepository,
                    app.container.searchHistoryRepository
                ) as T
            }
        }
    )

    val movie by viewModel.movieDetail.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val isInWatchlist by viewModel.isInWatchlist.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        return
    }

    if (error != null) {
        ErrorView(
            message = error!!,
            onRetry = { viewModel.loadMovie() },
            modifier = Modifier.fillMaxSize()
        )
        return
    }

    val m = movie ?: return

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // Hero Section with Backdrop
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(m.backdropUrl ?: m.posterUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.4f),
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.background
                                ),
                                startY = 0f,
                                endY = 800f
                            )
                        )
                )

                // Top Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), shape = MaterialTheme.shapes.extraLarge)
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Indietro", tint = Color.White)
                    }

                    Row {
                        IconButton(
                            onClick = { viewModel.toggleFavorite() },
                            modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), shape = MaterialTheme.shapes.extraLarge)
                        ) {
                            Icon(
                                if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                                contentDescription = "Preferito",
                                tint = if (isFavorite) MaterialTheme.colorScheme.primary else Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            onClick = {
                                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_TEXT, "Guarda \"${m.title}\" su CineTrack!\n\nhttps://www.themoviedb.org/movie/${m.id}")
                                }
                                context.startActivity(Intent.createChooser(shareIntent, "Condividi film"))
                            },
                            modifier = Modifier.background(Color.Black.copy(alpha = 0.5f), shape = MaterialTheme.shapes.extraLarge)
                        ) {
                            Icon(Icons.Filled.Share, contentDescription = "Condividi", tint = Color.White)
                        }
                    }
                }
            }
        }

        // Info Section
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-40).dp)
            ) {
                // Poster
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(m.posterUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .height(180.dp)
                        .clip(MaterialTheme.shapes.medium)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.padding(top = 48.dp)) {
                    Text(
                        text = m.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    if (m.originalTitle != m.title) {
                        Text(
                            text = m.originalTitle,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${m.year}${if (m.formattedRuntime != null) " • ${m.formattedRuntime}" else ""}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(rating = m.ratingOutOf5, voteAverage = m.voteAverage)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "(${m.voteCount.formatVoteCount()})",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Action Buttons
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-20).dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { viewModel.toggleWatchlist() },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isInWatchlist) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.primary,
                        contentColor = if (isInWatchlist) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Icon(
                        if (isInWatchlist) Icons.Filled.Check else Icons.Filled.Add,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (isInWatchlist) "In Watchlist" else "Watchlist")
                }

                if (m.trailer != null) {
                    OutlinedButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(m.trailer!!.youtubeUrl))
                            context.startActivity(intent)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Trailer")
                    }
                }
            }
        }

        // Genres
        item {
            FlowRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                m.genres.forEach { genre ->
                    GenreChip(name = genre.name)
                }
            }
        }

        // Tagline & Overview
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                if (!m.tagline.isNullOrEmpty()) {
                    Text(
                        text = "\"${m.tagline}\"",
                        style = MaterialTheme.typography.bodyLarge,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Text(
                    text = "Trama",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = m.overview ?: "Nessuna trama disponibile.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (!m.director.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Regista: ${m.director}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Cast
        if (m.cast.isNotEmpty()) {
            item {
                Text(
                    text = "Cast Principale",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(m.cast) { actor ->
                        CastCard(cast = actor)
                    }
                }
            }
        }

// Watch Providers
        if (m.watchProviders?.hasAnyProvider == true) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dove Guardarlo",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    val wp = m.watchProviders!!

                    if (wp.streaming.isNotEmpty()) {
                        Text("In Streaming", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
                        wp.streaming.forEach { provider ->
                            WatchProviderItem(provider = provider, link = null)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    if (wp.rent.isNotEmpty()) {
                        Text("A Noleggio", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
                        wp.rent.forEach { provider ->
                            WatchProviderItem(provider = provider, link = null)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    if (wp.buy.isNotEmpty()) {
                        Text("In Acquisto", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
                        wp.buy.forEach { provider ->
                            WatchProviderItem(provider = provider, link = null)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Text(
                        text = "Dati forniti da JustWatch",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
        // Similar Movies
        if (m.similarMovies.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalMovieList(
                    title = "Film Simili",
                    movies = m.similarMovies,
                    isLoading = false,
                    onMovieClick = { navController.navigate(Screen.Detail.createRoute(it)) }
                )
            }
        }
    }
}