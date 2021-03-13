package com.meteoro.composeoclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.meteoro.composeoclock.components.Clock
import com.meteoro.composeoclock.model.Time
import com.meteoro.composeoclock.ui.theme.ComposeOclockTheme
import kotlinx.coroutines.delay
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOclockTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ClockScreen()
                }
            }
        }
    }
}

@Composable
fun ClockScreen() {
    fun currentTime(): Time {
        val cal = Calendar.getInstance()
        return Time(
            hours = cal.get(Calendar.HOUR_OF_DAY),
            minutes = cal.get(Calendar.MINUTE),
            seconds = cal.get(Calendar.SECOND)
        )
    }

    var time by remember { mutableStateOf(currentTime()) }
    LaunchedEffect(0) {
        while (true) {
            time = currentTime()
            delay(1000)
        }
    }

    Clock(
        time = time
    )
}

@Preview
@Composable
fun ClockScreenPreview() {
    ClockScreen()
}