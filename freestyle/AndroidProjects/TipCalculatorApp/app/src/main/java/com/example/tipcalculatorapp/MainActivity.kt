package com.example.tipcalculatorapp

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculatorapp.ui.theme.TipCalculatorAppTheme
import kotlin.math.roundToLong

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ){
            TipCalculatorAppTheme {
                //TODO: schema() here pls
                TipCalculatorSchema()
            }}
        }
    }
}

@Composable
fun TipCalculatorSchema() {
    TipCalculatorApp()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TipCalculatorApp(modifier: Modifier = Modifier) {

    var bill by rememberSaveable { mutableStateOf("") }
    var tipP by rememberSaveable { mutableStateOf("")}
    var rounded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center

    ) {
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 60.dp)
                    .verticalScroll(rememberScrollState())
                    .safeDrawingPadding(),

            ){
                Text(
                    text = stringResource(R.string.calculate_tip),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 40.dp)
                    .verticalScroll(rememberScrollState())
                    .safeDrawingPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                // BILL AMOUNT INPUT FIELD
                OutlinedTextField(
                    value = bill,
                    onValueChange = {
                        bill = it
                    },
                    leadingIcon = (null),//TODO:
                    label = { Text(text = stringResource(R.string.bill_amount)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                    )
                Spacer(modifier = Modifier.height(15.dp))
                //TIP PERCENTAGE INPUT FIELD
                TextField(
                    value = tipP,
                    onValueChange = {
                        tipP = it
                    },
                    singleLine = true,
                    label = { Text(text = stringResource(R.string.tip_amount)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = stringResource(R.string.round_up_the_tip),
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(Modifier.weight(1f))
                    Row {
                        Switch(
                            checked = rounded,
                            onCheckedChange = {
                                rounded = it
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    text = "Tip Amount:${calculateTip(bill.toDoubleOrNull()?:0.00,tipP.toDoubleOrNull()?: 15.00, rounded)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp
                )
            }
        }


}

fun calculateTip(amount: Double, tipPercent: Double = 15.0, round: Boolean): String {
    val tip = tipPercent / 100 * amount
    if(round){
        return NumberFormat.getCurrencyInstance().format(tip.roundToLong())
    }else {

        return NumberFormat.getCurrencyInstance().format(tip)
    }
}



@Preview(showBackground = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorAppTheme {
        //TODO: schema() here
        TipCalculatorSchema()
    }
}