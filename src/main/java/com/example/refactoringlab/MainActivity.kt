// MainActivity.kt

package com.example.refactoringlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.refactoringlab.ui.theme.RefactoringLab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RefactoringLab2Theme {
                MainScreen()
            }
        }
    }
}
