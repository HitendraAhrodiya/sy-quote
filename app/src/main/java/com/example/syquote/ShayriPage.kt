package com.example.syquote

import android.R.attr.textSize
import android.R.id.content
import android.content.Intent
import android.media.Image
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButtonDefaults.borderStroke
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import java.nio.file.WatchEvent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShayriPage() {
    val pagerState = rememberPagerState(pageCount = { 200 }) // Set page count to 10

    val shuffledIndices = remember { (1..FinalShayari.size).shuffled() }
    val currentIndex = remember { mutableStateOf(shuffledIndices[0]) }

    VerticalPager(state = pagerState) { page ->
        currentIndex.value = shuffledIndices[page % shuffledIndices.size]
        Screen(number = currentIndex.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(number: Int) {

    val context = LocalContext.current
    val colors = listOf(
        Color(0x6583ACFF), Color(0xFFF4511E), Color(0xFFC3FF97),
        Color(0xFFF8F8F8), Color(0xFFDDB3DF), Color(0xFFD3FBFC),
        Color(0xFF8E94FF), Color(0xFFF3FFFF), Color(0xFFBBFCD3),
        Color(0xFF6FFBFF), Color(0xFFFDDE94), Color(0xFFEFB1FF),
        Color(0xFFBB82A6), Color(0xFF9CE0F1), Color(0xFFEEAABD),
        Color(0xFFBBFFF2), Color(0xFF8999FF), Color(0xFFF9FEFF),
        Color(0xFFF6E96B), Color(0xFF7FA1C3), Color(0xFFD2F1B0),
        Color(0xFFC8ADFF), Color(0xFFFF95BB), Color(0xFFFFBF78),
        Color(0xFF99B080), Color(0xFFD8B4F8), Color(0xFFE5D4FF),
        Color(0xFFBED7DC), Color(0xFF8090FF), Color(0xFF92C7CF),
        Color(0xFFB0EBB4), Color(0xFFFDD835), Color(0xFF00D3FF),
        )

    val color = colors[(number - 1) % colors.size]
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = FinalShayari[number] ?: "Content for screen $number",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.padding(top = 270.dp, start = 30.dp, end = 30.dp)
        )
        Spacer(modifier = Modifier.height(200.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    val textToShare = FinalShayari[number] ?: "Content for screen $number"
                    ShareText(context, textToShare)
                },

                modifier = Modifier.size(155.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(100.dp),
                border = (borderStroke(color = Color.Black, width = 2.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Share",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {
                    val textToCopy = FinalShayari[number] ?: "Content for screen $number"
                    CopyText(context, textToCopy)
                },

                modifier = Modifier.size(155.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(100.dp),
                border = (borderStroke(color = Color.Black, width = 2.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    colorFilter = (ColorFilter.tint(Color.Black))
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Copy",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                    fontSize = 18.sp
                )
            }

        }
    }
}



