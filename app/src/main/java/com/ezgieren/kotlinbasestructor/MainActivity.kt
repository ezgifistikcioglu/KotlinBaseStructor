package com.ezgieren.kotlinbasestructor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ezgieren.kotlinbasestructor.ui.theme.BaseProjectTheme
import com.ezgieren.kotlinbasestructor.ui.view.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseProjectTheme {
                HomeScreen()
            }
        }
    }
}