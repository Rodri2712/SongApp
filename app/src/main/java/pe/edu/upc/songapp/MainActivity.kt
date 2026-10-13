package pe.edu.upc.songapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.songapp.features.catalog.presentation.SongDetailScreen
import pe.edu.upc.songapp.features.catalog.presentation.SongsScreen
import pe.edu.upc.songapp.ui.theme.SongAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SongAppTheme {
                SongApp()
            }
        }
    }
}

@Composable
private fun SongApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "songs"
    ) {
        composable("songs") {
            SongsScreen(
                onSongClick = { songId ->
                    navController.navigate("song_detail/$songId")
                }
            )
        }

        composable(
            route = "song_detail/{songId}",
            arguments = listOf(
                navArgument("songId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val songId = backStackEntry.arguments?.getInt("songId") ?: return@composable

            SongDetailScreen(
                songId = songId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}