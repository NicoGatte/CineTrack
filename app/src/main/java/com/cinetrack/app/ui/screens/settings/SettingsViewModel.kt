package com.cinetrack.app.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val historyRepository: SearchHistoryRepository
) : ViewModel() {

    // Simple state holder for theme
    companion object {
        private val _isDarkTheme = MutableStateFlow(true)
        val isDarkTheme = _isDarkTheme.asStateFlow()
        
        fun toggleTheme() {
            _isDarkTheme.value = !_isDarkTheme.value
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            historyRepository.clearHistory()
        }
    }
}
