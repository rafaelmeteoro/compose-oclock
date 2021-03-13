package com.meteoro.composeoclock.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberColumn(
    current: Int,
    range: IntRange,
    modifier: Modifier = Modifier
) {
    val size = 40.dp

    val mid = (range.last - range.first) / 2f
    val reset = current == range.first
    val offset by animateDpAsState(
        targetValue = size * (mid - current),
        animationSpec = if (reset) {
            spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessLow
            )
        } else {
            tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        }
    )

    Column(
        modifier = modifier
            .offset(y = offset)
            .clip(RoundedCornerShape(percent = 25))
    ) {
        range.forEach { num ->
            Number(active = num == current, value = num, modifier = Modifier.size(size))
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