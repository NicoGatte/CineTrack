package com.cinetrack.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cinetrack.app.domain.model.TvShow

@Composable
fun HorizontalTvList(
    title: String,
    tvShows: List<TvShow>,
    isLoading: Boolean,
    onTvClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (!isLoading && tvShows.isEmpty()) return

    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (isLoading) {
                items(5) { MoviePosterShimmer() }
            } else {
                items(tvShows, key = { it.id }) { show ->
                    TvPosterCard(tvShow = show, onClick = { onTvClick(show.id) })
                }
            }
        }
    }
}