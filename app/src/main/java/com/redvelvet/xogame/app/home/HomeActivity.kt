package com.redvelvet.xogame.app.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.redvelvet.xogame.app.ui.theme.XogameTheme
import com.redvelvet.xogame.presentation.screens.GameBoardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XogameTheme {

            }
        }
    }
}

