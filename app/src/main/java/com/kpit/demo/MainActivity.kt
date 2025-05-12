package com.kpit.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kpit.demo.ui.DemoScreen
import com.kpit.demo.ui.theme.Cloud_orbit_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cloud_orbit_demoTheme {
                DemoScreen()
            }
        }
    }
}