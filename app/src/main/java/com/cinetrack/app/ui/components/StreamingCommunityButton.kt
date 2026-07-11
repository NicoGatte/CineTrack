package com.cinetrack.app.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

// Il dominio di StreamingCommunity cambia spesso: aggiorna qui quello attivo.
private const val STREAMING_COMMUNITY_BASE_URL = "https://streamingcommunity.vin"

@Composable
fun StreamingCommunityButton(
    title: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    OutlinedButton(
        onClick = {
            val url = "$STREAMING_COMMUNITY_BASE_URL/search?q=${Uri.encode(title)}"
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        },
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(Icons.Filled.OpenInNew, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("Cerca su StreamingCommunity")
    }
}