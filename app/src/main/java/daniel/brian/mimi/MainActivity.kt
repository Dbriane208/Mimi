package daniel.brian.mimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import daniel.brian.mimi.ui.theme.MimiTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-pro",
        apiKey = BuildConfig.API_KEY
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MimiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .verticalScroll(rememberScrollState())
                        .padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val coroutineScope = rememberCoroutineScope()

                        var input by remember { mutableStateOf("") }

                        var result by remember { mutableStateOf("")   }

                        var isProcessing by remember { mutableStateOf(false) }

                        TextField(
                            modifier = Modifier,
                            value = input,
                            onValueChange = { input = it },
                            label = { Text("Prompt the Model") }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(onClick = {
                            coroutineScope.launch {
                                isProcessing=true
                                val inputContent = content {
                                    text(input)
                                }
                                val response = generativeModel.generateContent(inputContent)
                                result = response.text.toString()
                                isProcessing=false
                            }
                        }, modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Submit")
                        }
                        AnimatedVisibility(visible = isProcessing) {
                            CircularProgressIndicator()
                        }
                        AnimatedVisibility(visible = result.isNotBlank()) {
                            Text(text = result)
                        }
                    }
                }
            }
        }
    }
}