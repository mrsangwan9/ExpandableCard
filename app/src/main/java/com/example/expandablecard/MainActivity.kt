package com.example.expandablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expandablecard.ui.theme.ExpandableCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   //ExpandableCard()
                }
            }
        }
    }
}
// a stateful composable function
// just to remember
@Composable
fun ExpandableCard() {
    Column(
              horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var cardValue by rememberSaveable { mutableStateOf(false) }
        var cardValue2 by rememberSaveable { mutableStateOf(false) }
        val rotationValue by animateFloatAsState(
            targetValue = if (cardValue) 180f else 0f
        )
        // a stateless composable function
        Card(  modifier = Modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
            )
        ),
            title = "ExpandableCard",
            des = "Lorem32 Let's start with a today with a new thinking that's might help todo something   \"great and wish i will   do that greatly\",",
            cardValue = cardValue,
            rotationValue = rotationValue,
            onwardChange = { cardValue = !cardValue }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(  modifier = Modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
            )
        ), title ="ExpandableCard2" ,
            cardValue = cardValue2,
            rotationValue = rotationValue,
            des ="lorem 32 we have to run away from now towards that will be great to know that it will be happen again",
             onwardChange = {cardValue2=!cardValue2})

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExpandableCardTheme {
Column( modifier = Modifier
    .fillMaxSize()
    .background(MaterialTheme.colors.primaryVariant)
    .padding(20.dp)
        ) {
    ExpandableCard()
}
}
    }

