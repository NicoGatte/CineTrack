package com.cinetrack.app.ui.screens.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/cinetrack/app/ui/screens/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "historyRepository", "Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "(Lcom/cinetrack/app/data/repository/SearchHistoryRepository;)V", "clearHistory", "", "Companion", "app_debug"})
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.SearchHistoryRepository historyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDarkTheme = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.cinetrack.app.ui.screens.settings.SettingsViewModel.Companion Companion = null;
    
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.SearchHistoryRepository historyRepository) {
        super();
    }
    
    public final void clearHistory() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/cinetrack/app/ui/screens/settings/SettingsViewModel$Companion;", "", "()V", "_isDarkTheme", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isDarkTheme", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "toggleTheme", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkTheme() {
            return null;
        }
        
        public final void toggleTheme() {
        }
    }
}