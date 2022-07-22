package com.example.expandablecard

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun Card(
    modifier: Modifier,
    title: String,
    cardValue:Boolean,
    rotationValue: Float,
    des: String,
    onwardChange: () ->Unit
) {
    Column(
        modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(start = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                title,
                modifier = Modifier.weight(6F),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                fontSize = 16.sp
            )
            IconButton(
                onClick = onwardChange,
                modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1F)
                    .rotate(rotationValue)
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "",
                )
            }
        }
        if (cardValue) {
            Text(
                des, modifier = Modifier.padding(bottom = 10.dp),
                overflow = TextOverflow.Ellipsis
            )
        }


    }
}
