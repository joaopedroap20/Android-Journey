package com.example.freestyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.freestyle.ui.theme.FreestyleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreestyleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    open class Phone(var isScreenLightOn: Boolean = false){
                        open fun switchOn() {
                            isScreenLightOn = true
                        }

                        fun switchOff() {
                            isScreenLightOn = false
                        }

                        fun checkPhoneScreenLight() {
                            val phoneScreenLight = if (isScreenLightOn) "on" else "off"
                            println("The phone screen's light is $phoneScreenLight.")
                        }
                    }

                    class FoldablePhone(var isFolded: Boolean = true) : Phone() {
                        override fun switchOn(){
                            if(!isFolded){
                                isScreenLightOn = true
                            }
                        }
                        fun fold() {
                            isFolded = true
                            isScreenLightOn = false
                        }
                        fun unfold() {
                            isFolded = false
                        }
                    }

                    fun main() {
                        val motorolaRazor = FoldablePhone()
                        motorolaRazor.checkPhoneScreenLight()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FreestyleTheme {

    }
}