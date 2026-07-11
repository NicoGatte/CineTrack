package com.cinetrack.app.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.imageLoader
import com.cinetrack.app.CineTrackApp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val app = context.applicationContext as CineTrackApp
    val coroutineScope = rememberCoroutineScope()
    
    val viewModel: SettingsViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SettingsViewModel(app.container.searchHistoryRepository) as T
            }
        }
    )
    
    val isDarkTheme by SettingsViewModel.isDarkTheme.collectAsState()
    var showClearHistoryDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Impostazioni", fontWeight = FontWeight.Bold) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        )
        
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "Aspetto",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                )
                
                ListItem(
                    headlineContent = { Text("Tema Scuro") },
                    supportingContent = { Text("Usa il tema scuro per l'applicazione") },
                    leadingContent = { Icon(Icons.Filled.Palette, contentDescription = null) },
                    trailingContent = {
                        Switch(
                            checked = isDarkTheme,
                            onCheckedChange = { SettingsViewModel.toggleTheme() }
                        )
                    }
                )
            }
            
            item {
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                Text(
                    text = "Dati e Archiviazione",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
                
                ListItem(
                    headlineContent = { Text("Cancella cronologia ricerche") },
                    leadingContent = { Icon(Icons.Filled.DeleteOutline, contentDescription = null) },
                    modifier = Modifier.clickable { showClearHistoryDialog = true }
                )
                
                ListItem(
                    headlineContent = { Text("Svuota cache immagini") },
                    leadingContent = { Icon(Icons.Filled.DeleteOutline, contentDescription = null) },
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            context.imageLoader.diskCache?.clear()
                            context.imageLoader.memoryCache?.clear()
                        }
                    }
                )
            }
            
            item {
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                Text(
                    text = "Informazioni",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
                
                ListItem(
                    headlineContent = { Text("Versione App") },
                    supportingContent = { Text("1.0.0") },
                    leadingContent = { Icon(Icons.Filled.Info, contentDescription = null) }
                )
                
                ListItem(
                    headlineContent = { Text("Dati forniti da") },
                    supportingContent = { Text("TMDb (The Movie Database)\nStreaming: JustWatch") },
                    leadingContent = { Icon(Icons.Filled.Info, contentDescription = null) }
                )
            }
        }
    }
    
    if (showClearHistoryDialog) {
        AlertDialog(
            onDismissRequest = { showClearHistoryDialog = false },
            title = { Text("Cancella cronologia") },
            text = { Text("Sei sicuro di voler cancellare tutta la cronologia delle ricerche?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.clearHistory()
                        showClearHistoryDialog = false
                    }
                ) {
                    Text("Cancella")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearHistoryDialog = false }) {
                    Text("Annulla")
                }
            }
        )
    }
}
