package com.example.digitallemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitallemonadeapp.ui.theme.DigitalLemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalLemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    LemonSchema()
                }
            }
        }
    }
}
@Composable
fun LemonSchema(modifier: Modifier = Modifier) {
    LemonadeStandApp()
}
@Composable
fun LemonadeStandApp(modifier: Modifier = Modifier) {

    //remember scaffold keyword

    //fun with the header layout and where the button is stored.
    LemonadeHeader(stringResource(R.string.lemonade_simple_text), Color.Yellow, 18)
}
@Composable
fun LemonadeHeader(
    text: String,
    color: Color,
    fontSize: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(

            modifier = modifier
                .background(
                    color = color
                )
        ) {
            Text(
                fontSize = fontSize.sp,
                text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        16.dp
                    )
                    .weight(1f),
                fontWeight = FontWeight.Bold,
            )
        }
        ButtonAndLabel()
    }
}
@Composable
fun ButtonAndLabel(
    modifier: Modifier = Modifier
) {
    //Variable dedicated to determine the current step(1..4)
    var lemonStep by remember { mutableStateOf(1) }
    //Specific for step 2 where a random # between 2 - 4 number of times to press button to go to next step
    var randSqueezeCount by remember { mutableStateOf(0) }

    val imageId = when(lemonStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.ic_launcher_foreground
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier.align(alignment = Alignment.Center) //finally
        ) {
            Row(
                //onClick = { println("lemon button pressed") },
                //colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF99EDC3)),
                //shape = RoundedCornerShape(15),
                modifier = Modifier
                    .drawWithCache {
                        val brush = Brush.linearGradient(
                            listOf(
                                Color(0xFF9E82F0),
                                Color(0xFF42A5F5)
                            )
                        )
                        onDrawBehind {
                            drawRoundRect(
                                brush,
                                cornerRadius = CornerRadius(15.dp.toPx())
                            )
                        }
                    }

            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Sunset",
                    modifier = Modifier
                        .graphicsLayer {
                            this.rotationX = 90f
                            this.rotationY = 275f
                            this.rotationZ = 180f
                        }
                )
            }
        }
    }
    Row(
        modifier = modifier
    ) {
        Text(
            text = stringResource(imageId), modifier = Modifier.padding(30.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DigitalLemonadePreview() {
    LemonSchema()
}