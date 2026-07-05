package com.cinetrack.app.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cinetrack.app.ui.theme.CineGold

@Composable
fun RatingBar(
    rating: Float, // 0.0 to 5.0
    voteAverage: Double, // 0.0 to 10.0
    modifier: Modifier = Modifier,
    compact: Boolean = false,
    showText: Boolean = true
) {
    val starSize = if (compact) 14.dp else 18.dp
    val textStyle = if (compact) MaterialTheme.typography.labelSmall else MaterialTheme.typography.titleSmall
    
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!compact) {
            val fullStars = rating.toInt()
            val hasHalfStar = rating - fullStars >= 0.5f
            
            for (i in 1..5) {
                val icon = when {
                    i <= fullStars -> Icons.Filled.Star
                    i == fullStars + 1 && hasHalfStar -> Icons.Filled.StarHalf
                    else -> Icons.Outlined.StarOutline
                }
                
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = CineGold,
                    modifier = Modifier.size(starSize)
                )
            }
        } else {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = CineGold,
                modifier = Modifier.size(starSize)
            )
        }
        
        if (showText) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = String.format("%.1f", voteAverage),
                style = textStyle,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
