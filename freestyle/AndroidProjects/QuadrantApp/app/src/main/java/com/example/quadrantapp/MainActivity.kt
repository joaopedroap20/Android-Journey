package com.example.quadrantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantapp.ui.theme.QuadrantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    QuadrantSchema()
                }
            }
        }
    }
}

@Composable
fun QuadrantSchema() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            Modifier
                .weight(1f)
        ) {
            Spacer(modifier = Modifier.weight(.4f))
            Quadrant(
                stringResource(R.string.text_c),
                stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                Color(0xFFEADDFF),
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(.4f))
        }
        Row(
            Modifier
                .weight(1f)
        ) {
            Quadrant(
                text1 = stringResource(R.string.row_c),
                text2 = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_horizontal_sequence),
                Color(0xFFB69DF8),
                Modifier.weight(1f)

            )
            Quadrant(
                text1 = stringResource(R.string.column_c),
                text2 = stringResource(R.string.a_layout_composable_that_places_its_children_in_a_vertical_sequence),
                Color(0xFFF6EDFF),
                Modifier.weight(1f)
            )
        }
        Row(
            Modifier
                .weight(1f)
        ) {
            Spacer(modifier = Modifier.weight(.4f))
            Quadrant(
                stringResource(R.string.image_c),
                stringResource(R.string.creates_a_composable_that_lays_out_and_draws_a_given_painter_class_object),
                Color(0xFFD0BCFF),
                Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(.4f))
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Quadrant(text1: String, text2: String, color: Color, modifier: Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = color)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = text1,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(
                    bottom = 16.dp
                ),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text2,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),

            textAlign = TextAlign.Justify
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantAppTheme {
        QuadrantSchema()
    }

}