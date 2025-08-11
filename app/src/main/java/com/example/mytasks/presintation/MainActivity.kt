package com.example.mytasks.presintation

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
import com.example.mytasks.presintation.mainScreen.MainScreen
import com.example.mytasks.presintation.viewModelPack.TaskViewModel
import com.example.mytasks.presintation.viewModelPack.ViewModelFactory
import com.example.mytasks.ui.theme.MyTasksTheme

class MainActivity : ComponentActivity() {

    private val taskDatabase by lazy { TaskDatabase.getDatabase(application) }
    private val repositoryTask by lazy { TaskRepositoryImpl(taskDatabase) }
    private val viewModelFactory by lazy {
        ViewModelFactory(
            application = application,
            repositoryTask = repositoryTask
        )
    }
    private val taskViewModel: TaskViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
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