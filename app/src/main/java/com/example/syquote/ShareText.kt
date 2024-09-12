package com.example.syquote

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable


fun ShareText(context: Context, text: String) {
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(intent, "Share via"))
}