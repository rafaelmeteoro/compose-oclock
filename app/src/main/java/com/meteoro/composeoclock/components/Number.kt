package com.meteoro.composeoclock.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Number(value: Int, active: Boolean) {
    val backgroundColor by animateColorAsState(
        if (active) MaterialTheme.colors.primary else
            MaterialTheme.colors.primaryVariant
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .background(backgroundColor)
    ) {
        Text(
            text = value.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun NumberPreview() {
    Column {
        Number(value = 3, true)
        Number(value = 7, false)
    }
}