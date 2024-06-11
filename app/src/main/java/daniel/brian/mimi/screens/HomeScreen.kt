package daniel.brian.mimi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import daniel.brian.mimi.R
import daniel.brian.mimi.ui.theme.Blue
import daniel.brian.mimi.ui.theme.Pink40
import daniel.brian.mimi.ui.theme.poppinsFamily

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 240.dp, height = 100.dp)
        ) {

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_pic),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .aspectRatio(1f),
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                ElevatedCard(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(width = 240.dp, height = 200.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    val gradientColors = listOf(Cyan,Blue,Pink40)
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = stringResource(id = R.string.mimi),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Thin,
                        fontFamily = poppinsFamily,
                        style = TextStyle(
                            fontSize = 19.sp,
                            brush = Brush.linearGradient(
                                colors = gradientColors
                            )
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 240.dp, height = 60.dp),
                    onClick = {  },
                ) {
                    Text(
                        modifier = modifier,
                        text = stringResource(R.string.join),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Thin,
                        fontFamily = poppinsFamily,
                    )
                }
            }
        }

    }
}
@Preview
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen(modifier = modifier)
}