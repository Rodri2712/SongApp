package pe.edu.upc.songapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val SongAppColorScheme = lightColorScheme(
    primary = SongAppPrimary,
    onPrimary = SongAppOnPrimary,
    primaryContainer = SongAppSecondary,
    onPrimaryContainer = SongAppOnSecondary,

    secondary = SongAppSecondary,
    onSecondary = SongAppOnSecondary,

    background = SongAppBackground,
    onBackground = SongAppText,

    surface = SongAppSurface,
    onSurface = SongAppText,

    surfaceVariant = SongAppSecondary,
    onSurfaceVariant = SongAppTextSecondary,

    outline = SongAppOutline,
    error = SongAppError,
    onError = SongAppOnPrimary
)

@Composable
fun SongAppTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SongAppColorScheme,
        typography = Typography,
        content = content
    )
}