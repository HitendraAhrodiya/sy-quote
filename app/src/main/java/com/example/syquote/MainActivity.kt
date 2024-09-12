package com.example.syquote


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import com.example.syquote.ui.theme.SYQuoteTheme
import androidx.compose.ui.Modifier
import com.example.syquote.FinalShayari

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppNavigation()
        }
    }
}



