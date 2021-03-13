package com.meteoro.composeoclock.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meteoro.composeoclock.model.Time

@Composable
fun Clock(time: Time) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val padding = Modifier.padding(horizontal = 4.dp)

        NumberColumn(current = time.hours / 10, range = 0..2, padding)
        NumberColumn(current = time.hours % 10, range = 0..9, padding)

        Spacer(modifier = Modifier.size(16.dp))

        NumberColumn(current = time.minutes / 10, range = 0..5, padding)
        NumberColumn(current = time.minutes % 10, range = 0..9, padding)

        Spacer(modifier = Modifier.size(16.dp))

        NumberColumn(current = time.seconds / 10, range = 0..5, padding)
        NumberColumn(current = time.seconds % 10, range = 0..9, padding)
    }
}

@Preview
@Composable
fun ClockPreview() {
    Clock(
        time = Time(hours = 14, minutes = 15, seconds = 59)
    )
}