package com.cinetrack.app.ui.screens.watchlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cinetrack.app.CineTrackApp
import com.cinetrack.app.ui.components.EmptyState
import com.cinetrack.app.ui.components.RatingBar
import com.cinetrack.app.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp
    
    val viewModel: WatchlistViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return WatchlistViewModel(app.container.watchlistRepository) as T
            }
        }
    )

    val allItems by viewModel.allItems.collectAsStateWithLifecycle()
    val watchedItems by viewModel.watchedItems.collectAsStateWithLifecycle()
    val unwatchedItems by viewModel.unwatchedItems.collectAsStateWithLifecycle()
    
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Tutti", "Da Vedere", "Visti")
    
    val currentItems = when (selectedTabIndex) {
        1 -> unwatchedItems
        2 -> watchedItems
        else -> allItems
    }

    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("La mia Watchlist", fontWeight = FontWeight.Bold) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        )
        
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { 
                        val count = when(index) {
                            1 -> unwatchedItems.size
                            2 -> watchedItems.size
                            else -> allItems.size
                        }
                        Text("$title ($count)")
                    }
                )
            }
        }

        if (currentItems.isEmpty()) {
            EmptyState(
                icon = Icons.Filled.BookmarkBorder,
                title = "Watchlist vuota",
                description = "Aggiungi film alla tua watchlist per ritrovarli qui.",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    items = currentItems,
                    key = { it.movieId }
                ) { item ->
                    val dismissState = rememberSwipeToDismissBoxState()
                    
                    if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
                        LaunchedEffect(item.movieId) {
                            viewModel.removeFromWatchlist(item.movieId)
                        }
                    }
                    
                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromStartToEnd = false,
                        backgroundContent = {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(MaterialTheme.shapes.medium)
                                    .background(MaterialTheme.colorScheme.error)
                                    .padding(end = 16.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    Icons.Filled.Delete,
                                    contentDescription = "Elimina",
                                    tint = Color.White
                                )
                            }
                        },
                        content = {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { navController.navigate(Screen.Detail.createRoute(item.movieId)) },
                                shape = MaterialTheme.shapes.medium,
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                )
                            ) {
                                Row(
                                    modifier = Modifier.height(120.dp)
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(item.posterUrl)
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.width(80.dp).fillMaxHeight()
                                    )
                                    
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(12.dp)
                                    ) {
                                        Text(
                                            text = item.title,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = item.year,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        RatingBar(rating = item.ratingOutOf5, voteAverage = item.voteAverage, compact = true)
                                    }
                                    
                                    IconButton(
                                        onClick = { viewModel.toggleWatched(item.movieId, !item.isWatched) },
                                        modifier = Modifier.align(Alignment.CenterVertically).padding(end = 8.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (item.isWatched) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
                                            contentDescription = "Segna come visto",
                                            tint = if (item.isWatched) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
