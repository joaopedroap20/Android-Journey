package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.ui.theme.CoursesAppTheme
import com.example.courseapp.data.Datasource
import com.example.coursesapp.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    TopicGrid()
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(8.dp)
    ) {
        items(Datasource.topics) { topic ->
            TopicCard(topic)
        }
    }
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.height(68.dp)
        ) {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .size(68.dp),
                contentScale = ContentScale.Fit
            )
            Column(
            ) {
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp,
                            top = 16.dp
                        )
                )
                Row(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 8.dp
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "1",
                        colorFilter = ColorFilter.tint(color = Color.DarkGray)
                    )
                    Text(
                        text = topic.count.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppPreview() {

    CoursesAppTheme {
        val topic = Topic(R.string.architecture, 321, R.drawable.photography)
        TopicCard(topic = topic)
    }
}