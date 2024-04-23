package com.example.rollthedice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rollthedice.ui.theme.RollTheDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollTheDiceTheme {
                DiceRollerApp()
            }
        }
    }
}


// passing a modifier parameter of type Modifier to style this Composable UI elements
// the modifier parameter is assigned a default value of Modifier
// one can pass a custom Modifier object to modifier param to style the UI their own way
// if no value is passed to modifier param, the default Modifier object is used
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    // taking the whole size of the screen
    .fillMaxSize()
    // wrapping around the contents and then placing them in the center (vertically & horizontally)
    .wrapContentSize(Alignment.Center)
) {
    // dice result
    var result by remember { mutableStateOf(1) }
    // connecting each result number to its image
    val diceImg = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        // passing the above modifier object with preset styles down to this child composable
        // to make sure it adheres to the parent styles set in the modifier object
        modifier = modifier,
        // aligning column's elements to the center horizontally
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            // image displayed depends on the result variable
            painter = painterResource(id = diceImg),
            contentDescription = "dice $result"
        )

        // adding vertical space between the image and the button
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}
