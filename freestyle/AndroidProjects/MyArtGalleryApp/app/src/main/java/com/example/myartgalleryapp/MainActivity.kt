package com.example.myartgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myartgalleryapp.ui.theme.MyArtGalleryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtGalleryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //TODO:
                    GallerySchema()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GallerySchema() {
    GalleryLayout()
}

@Composable
fun ArtworkFrame(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }

    val colorMatrix = floatArrayOf(
        -1f, 0f, 0f, 0f, 255f,
        0f, -1f, 0f, 0f, 255f,
        0f, 0f, -1f, 0f, 255f,
        0f, 0f, 0f, 1f, 0f
    )

    //ARTWORK FRAME
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            //.border(20.dp, Color.Blue)
            .padding(bottom = 10.dp)
            .shadow(5.dp)
    ) {
        Image(
            painter = painterResource(
                id =R.drawable.art_1
            ),
            contentDescription = null,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .padding(20.dp),

        )
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(R.string.art_2),
            textAlign = TextAlign.Justify,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Dreamworks Animations(2001)",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun CycleButtons(artId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth(),


            ) {
            Spacer(modifier = Modifier.weight(.2f))
            Button(
                onClick = {
                          when(artId) {
                              1->
                          }
                },

                ) {
                Text(text = stringResource(R.string.previous))

            }

            Spacer(modifier = Modifier.weight(3f))

            Button(
                onClick = { /*TODO*/ },

                ) {
                Text(text = stringResource(R.string.next))


            }
            Spacer(modifier = Modifier.weight(.2f))
        }
    }
}

@Composable
fun GalleryLayout(
    /*descriptorResourceId: Int,
    artResourceId: Int,
    contentDescriptionResourceId: Int,
    onButtonClick: () -> Unit,*/
    modifier: Modifier = Modifier
) {


    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        Spacer(modifier = Modifier.weight(.1f))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            //ARTWORK FRAME
            Column(

            ) {
                ArtworkFrame()
            }
            Spacer(modifier = Modifier.weight(1f))
            //ARTWORK DESCRIPTOR
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize()
                    .weight(1f)
            ) {
                ArtworkDescriptor()
            }
            //BUTTON LAYOUT / DISPLAY CONTROLLER [PREVIOUS, NEXT]
            Column(
                modifier = Modifier.weight(1f)
            ) {

                CycleButtons()
            }
        }
        Spacer(modifier = Modifier.weight(.1f))
    }
}