package com.cinetrack.app.ui.screens.reels

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.cinetrack.app.ui.components.YouTubePlayer
import com.cinetrack.app.ui.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReelsScreen(navController: NavController) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp

    val viewModel: ReelsViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ReelsViewModel(
                    app.container.movieRepository,
                    app.container.tvShowRepository
                ) as T
            }
        }
    )

    val uiState by viewModel.uiState.collectAsState()
    val pagerState = rememberPagerState(pageCount = { uiState.items.size })

    LaunchedEffect(pagerState.currentPage, uiState.items.size) {
        if (uiState.items.isNotEmpty()) {
            viewModel.loadTrailerFor(pagerState.currentPage)
            viewModel.loadTrailerFor(pagerState.currentPage + 1)
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        if (uiState.isLoading && uiState.items.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        } else if (uiState.items.isNotEmpty()) {
            VerticalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                val item = uiState.items[page]
                ReelPage(
                    item = item,
                    isActive = page == pagerState.currentPage,
                    onOpenDetail = {
                        val route = if (item.isTv) {
                            Screen.TvDetail.createRoute(item.id)
                        } else {
                            Screen.Detail.createRoute(item.id)
                        }
                        navController.navigate(route)
                    }
                )
            }
        }

        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 40.dp, start = 8.dp)
                .background(
                    Color.Black.copy(alpha = 0.4f),
                    shape = MaterialTheme.shapes.extraLarge
                )
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Indietro",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun ReelPage(item: ReelItem, isActive: Boolean, onOpenDetail: () -> Unit) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        if (isActive && !item.trailerKey.isNullOrEmpty()) {
            YouTubePlayer(
                videoId = item.trailerKey,
                modifier = Modifier.fillMaxSize(),
                isPlaying = isActive
            )
        } else {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(item.backdropUrl ?: item.posterUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            if (item.isLoadingTrailer) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            } else if (!item.trailerKey.isNullOrEmpty()) {
                IconButton(
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=${item.trailerKey}")
                        )
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(
                            Color.Black.copy(alpha = 0.6f),
                            shape = MaterialTheme.shapes.extraLarge
                        )
                ) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = "Guarda su YouTube",
                        tint = Color.White,
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.85f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp)
        ) {
            Text(
                text = item.title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onOpenDetail) {
                Text(if (item.isTv) "Vedi serie" else "Vedi film")
            }
        }
    }
}