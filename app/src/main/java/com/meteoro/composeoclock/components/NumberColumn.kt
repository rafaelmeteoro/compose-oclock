package com.meteoro.composeoclock.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NumberColumn(
    range: IntRange,
    current: Int
) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(percent = 25))
    ) {
        range.forEach { num ->
            Number(
                value = num,
                active = num == current
            )
        }
    }
}

@Preview
@Composable
fun NumberColumnPreview() {
    NumberColumn(
        range = 0..9,
        current = 5
    )
}