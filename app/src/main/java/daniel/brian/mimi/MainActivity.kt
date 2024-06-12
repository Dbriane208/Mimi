package daniel.brian.mimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import daniel.brian.mimi.navigation.Navigation
import daniel.brian.mimi.ui.theme.MimiTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MimiTheme {
                Navigation()
            }
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        MimiTheme {
            content()
        }

    }

    @Preview
    @Composable
    fun Preview(modifier: Modifier = Modifier) {
        MyApp {
            MimiTheme {
                Navigation()
            }
        }

    }
}