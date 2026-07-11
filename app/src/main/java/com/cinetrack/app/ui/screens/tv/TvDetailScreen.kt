package com.cinetrack.app.ui.screens.tv

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
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
fun TvDetailScreen(tvId: Int, navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp

    val viewModel: TvDetailViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TvDetailViewModel(tvId, app.container.tvShowRepository) as T
            }
        }
    )

    val show by viewModel.tvDetail.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        return
    }

    if (error != null) {
        ErrorView(message = error!!, onRetry = { viewModel.loadTvShow() }, modifier = Modifier.fillMaxSize())
        return
    }

    val s = show ?: return

    LazyColumn(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(s.backdropUrl ?: s.posterUrl).crossfade(true).build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier.fillMaxSize().background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.4f), Color.Transparent, MaterialTheme.colorScheme.background),
                            startY = 0f, endY = 800f
                        )
                    )
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 48.dp, start = 16.dp)
                        .background(Color.Black.copy(alpha = 0.5f), shape = MaterialTheme.shapes.extraLarge)
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Indietro", tint = Color.White)
                }
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).offset(y = (-40).dp)) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(s.posterUrl).crossfade(true).build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(120.dp).height(180.dp).clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.padding(top = 48.dp)) {
                    Text(s.name, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    if (s.originalName != s.name) {
                        Text(s.originalName, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${s.year}${if (s.formattedSeasons != null) " â€¢ ${s.formattedSeasons}" else ""}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(rating = s.ratingOutOf5, voteAverage = s.voteAverage)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("(${s.voteCount.formatVoteCount()})", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }

        if (s.trailer != null) {
            item {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).offset(y = (-20).dp)) {
                    OutlinedButton(onClick = {
                        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(s.trailer!!.youtubeUrl)))
                    }) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Trailer")
                    }
                }
            }
        }

        item {
            FlowRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                s.genres.forEach { GenreChip(name = it.name) }
            }
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                if (!s.tagline.isNullOrEmpty()) {
                    Text("\"${s.tagline}\"", style = MaterialTheme.typography.bodyLarge, fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(bottom = 16.dp))
                }
                Text("Trama", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
                Text(s.overview ?: "Nessuna trama disponibile.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        if (s.cast.isNotEmpty()) {
            item {
                Text("Cast Principale", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(s.cast) { actor -> CastCard(cast = actor) }
                }
            }
        }

        if (s.watchProviders?.hasAnyProvider == true) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Dove Guardarlo", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                    val wp = s.watchProviders!!
                    if (wp.streaming.isNotEmpty()) {
                        Text("In Streaming", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
                        wp.streaming.forEach { WatchProviderItem(provider = it, link = null ) }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Text("Dati forniti da JustWatch", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }

        if (s.similarShows.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalTvList(
                    title = "Serie Simili",
                    tvShows = s.similarShows,
                    isLoading = false,
                    onTvClick = { navController.navigate(Screen.TvDetail.createRoute(it)) }
                )
            }
        }
    }
}
