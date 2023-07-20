package com.redvelvet.xogame.app.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.redvelvet.xogame.app.navigate.XoNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            XoNavGraph(navController = navController)
        }
    }

    override fun onPause() {
        viewModel.makeUserOffline()
        super.onPause()
    }

    override fun onResume() {
        viewModel.makeUserOnline()
        super.onResume()
    }
}

