package com.example.myandroidbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidbusinesscard.ui.theme.MyAndroidBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAndroidBusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    placeHolderSchema()
                }
            }
        }
    }
}

@Composable
fun placeHolderSchema() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        //TODO: MAIN LOGO
        Image(
            painter = painterResource(R.drawable.artstationlogo),
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clip(CircleShape)
                .size(200.dp)
        )
        //TODO: NAME
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            text = "João Pereira",
            fontWeight = FontWeight.Bold
        )
        //TODO: TITLE/POSITION
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            text = "Rockstar Developer\n           @CTW"
        )
        //TODO: PHONE CONTACT ICON
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.phone),
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                text = "+351 939 768 568"

            )
        }
        //TODO: URL ICON (LINKED IN OR GITHUB)
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.network),
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = "github.com/joaopedroap20"
            )
        }

        //TODO: EMAIL ADDRESS ICON
        Row(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.mail),
                contentDescription = null,

                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = "joaopedroap20@gmail.com"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    placeHolderSchema()
}

