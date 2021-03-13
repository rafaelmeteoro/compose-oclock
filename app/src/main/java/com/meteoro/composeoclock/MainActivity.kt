package com.meteoro.composeoclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.meteoro.composeoclock.components.Clock
import com.meteoro.composeoclock.components.Number
import com.meteoro.composeoclock.components.NumberColumn
import com.meteoro.composeoclock.model.Time
import com.meteoro.composeoclock.ui.theme.ComposeOclockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOclockTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Clock(
                        time = Time(14, 15, 59)
                    )
                }
            }
        }
    }
}