package com.meteoro.composeoclock.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meteoro.composeoclock.model.Time

@Composable
fun Clock(time: Time) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NumberColumn(range = 0..2, current = time.hours / 10)
        NumberColumn(range = 0..9, current = time.hours % 10)
        NumberColumn(range = 0..5, current = time.minutes / 10)
        NumberColumn(range = 0..9, current = time.minutes % 10)
        NumberColumn(range = 0..5, current = time.seconds / 10)
        NumberColumn(range = 0..9, current = time.seconds % 10)
    }
}

@Preview
@Composable
fun ClockPreview() {
    Clock(
        time = Time(hours = 14, minutes = 15, seconds = 59)
    )
}