package com.cinetrack.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cinetrack.app.domain.model.FilterOptions
import com.cinetrack.app.domain.model.Genre
import com.cinetrack.app.domain.model.SortOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    genres: List<Genre>,
    currentFilters: FilterOptions,
    onApplyFilters: (FilterOptions) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedGenreId by remember { mutableStateOf(currentFilters.genreId) }
    var minRating by remember { mutableStateOf(currentFilters.minRating) }
    var sortBy by remember { mutableStateOf(currentFilters.sortBy) }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Filtri",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Ordina per
            Text(
                text = "Ordina per",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(SortOption.values()) { option ->
                    FilterChip(
                        selected = sortBy == option,
                        onClick = { sortBy = option },
                        label = { Text(option.displayName) }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Genere
            Text(
                text = "Genere",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    FilterChip(
                        selected = selectedGenreId == null,
                        onClick = { selectedGenreId = null },
                        label = { Text("Tutti") }
                    )
                }
                items(genres) { genre ->
                    FilterChip(
                        selected = selectedGenreId == genre.id,
                        onClick = { selectedGenreId = genre.id },
                        label = { Text(genre.name) }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Rating Minimo
            Text(
                text = "Rating Minimo: ${String.format("%.1f", minRating)}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Slider(
                value = minRating,
                onValueChange = { minRating = it },
                valueRange = 0f..10f,
                steps = 19
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        selectedGenreId = null
                        minRating = 0f
                        sortBy = SortOption.POPULARITY_DESC
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reset")
                }
                
                Button(
                    onClick = {
                        onApplyFilters(
                            FilterOptions(
                                genreId = selectedGenreId,
                                minRating = minRating,
                                sortBy = sortBy
                            )
                        )
                        onDismiss()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Applica")
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
