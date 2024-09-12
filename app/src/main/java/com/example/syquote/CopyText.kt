package com.example.syquote

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context



fun CopyText(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", text)
    clipboard.setPrimaryClip(clip)
}


