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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column(
        // passing the above modifier object with preset styles down to this child composable
        // to make sure it adheres to the parent styles set in the modifier object
        modifier = modifier,
        // aligning column's elements to the center horizontally
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dice_1),
            contentDescription = "dice 1"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}
