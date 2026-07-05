@echo off
setlocal

set BASE=%~dp0
set PROJECT_DIR=%CD%

echo Cerco il progetto film_searcher a partire dalla cartella corrente...
echo Cartella corrente: %PROJECT_DIR%

set MAINACT=%PROJECT_DIR%\app\src\main\java\com\cinetrack\app\MainActivity.kt
set CREDITS=%PROJECT_DIR%\app\src\main\java\com\cinetrack\app\data\api\dto\CreditsDto.kt

if not exist "%MAINACT%" (
    echo ERRORE: non trovo MainActivity.kt in %MAINACT%
    echo Esegui questo script dalla cartella principale del progetto film_searcher
    pause
    exit /b 1
)

if not exist "%CREDITS%" (
    echo ERRORE: non trovo CreditsDto.kt in %CREDITS%
    pause
    exit /b 1
)

echo Backup dei file originali...
copy "%MAINACT%" "%MAINACT%.bak" >nul
copy "%CREDITS%" "%CREDITS%.bak" >nul

echo Scrivo il nuovo MainActivity.kt...
(
echo package com.cinetrack.app
echo.
echo import android.os.Bundle
echo import androidx.activity.ComponentActivity
echo import androidx.activity.compose.setContent
echo import androidx.activity.enableEdgeToEdge
echo import androidx.compose.foundation.layout.fillMaxSize
echo import androidx.compose.material3.MaterialTheme
echo import androidx.compose.material3.Surface
echo import androidx.compose.runtime.getValue
echo import androidx.compose.ui.Modifier
echo import androidx.lifecycle.compose.collectAsStateWithLifecycle
echo import com.cinetrack.app.ui.navigation.CineTrackNavGraph
echo import com.cinetrack.app.ui.screens.settings.SettingsViewModel
echo import com.cinetrack.app.ui.theme.CineTrackTheme
echo.
echo class MainActivity : ComponentActivity^(^) {
echo     override fun onCreate^(savedInstanceState: Bundle?^) {
echo         super.onCreate^(savedInstanceState^)
echo         enableEdgeToEdge^(^)
echo         setContent {
echo             val isDarkTheme by SettingsViewModel.isDarkTheme.collectAsStateWithLifecycle^(^)
echo             CineTrackTheme^(darkTheme = isDarkTheme^) {
echo                 Surface^(
echo                     modifier = Modifier.fillMaxSize^(^),
echo                     color = MaterialTheme.colorScheme.background
echo                 ^) {
echo                     CineTrackNavGraph^(^)
echo                 }
echo             }
echo         }
echo     }
echo }
) > "%MAINACT%"

echo Scrivo il nuovo CreditsDto.kt...
(
echo package com.cinetrack.app.data.api.dto
echo.
echo import com.squareup.moshi.Json
echo import com.squareup.moshi.JsonClass
echo.
echo @JsonClass^(generateAdapter = true^)
echo data class CreditsDto^(
echo     val cast: List^<CastDto^>,
echo     val crew: List^<CrewDto^>
echo ^)
echo.
echo @JsonClass^(generateAdapter = true^)
echo data class CastDto^(
echo     val id: Int,
echo     val name: String,
echo     @Json^(name = "original_name"^) val originalName: String,
echo     val character: String?,
echo     @Json^(name = "profile_path"^) val profilePath: String?,
echo     val order: Int,
echo     val popularity: Double
echo ^)
echo.
echo @JsonClass^(generateAdapter = true^)
echo data class CrewDto^(
echo     val id: Int,
echo     val name: String,
echo     @Json^(name = "profile_path"^) val profilePath: String?,
echo     val department: String,
echo     val job: String
echo ^)
) > "%CREDITS%"

echo.
echo Fatto! File aggiornati:
echo   %MAINACT%
echo   %CREDITS%
echo.
echo Backup salvati con estensione .bak nella stessa cartella.
echo Ora torna su Android Studio, fai Sync Now se richiesto, poi Build - Rebuild Project.
pause
