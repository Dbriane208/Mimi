package daniel.brian.mimi.navigation

enum class MimiScreens {
    HomeScreen,TriviaScreen;
    companion object{
        fun fromRoute(route : String?): MimiScreens =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                TriviaScreen.name -> TriviaScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}