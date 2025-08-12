package com.example.mytasks.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mytasks.data.database.TaskDatabase
import com.example.mytasks.data.repositoryImpl.TaskRepositoryImpl
import com.example.mytasks.di.AppMyTasks
import com.example.mytasks.presentation.mainScreen.MainScreen
import com.example.mytasks.presentation.viewModelPack.TaskViewModel
import com.example.mytasks.presentation.viewModelPack.ViewModelFactory
import com.example.mytasks.ui.theme.MyTasksTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val taskViewModel: TaskViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AppMyTasks).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTasksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(taskViewModel = taskViewModel)
                }
            }
        }
    }
}