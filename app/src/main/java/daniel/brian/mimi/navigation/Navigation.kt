package daniel.brian.mimi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import daniel.brian.mimi.screens.HomeScreen
import daniel.brian.mimi.screens.TriviaScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MimiScreens.HomeScreen.name){
        composable(MimiScreens.HomeScreen.name){
            HomeScreen(modifier = Modifier,navController = navController)
        }
        composable(MimiScreens.TriviaScreen.name){
            TriviaScreen(navController = navController)
        }
    }
}