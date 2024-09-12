package com.example.syquote


import android.os.Build
import android.view.Surface
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import java.nio.file.WatchEvent


@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(color = Color(0xFF50706D)),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            fontSize = 60.sp,
            modifier = Modifier.padding(top = 160.dp, start = 20.dp),
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "SY Quote", fontSize = 35.sp, modifier = Modifier.padding(start = 200.dp), style = TextStyle(Color(
            0xFFF7EFE5
        )
        ), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(100.dp))

        Box(modifier = Modifier.padding(start = 130.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_downward_24),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Click the button  & scrolling", modifier = Modifier.padding(start = 100.dp),style = TextStyle(Color(
            0xFFCCC5C5
        )
        ))
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = {
                navController.navigate("ShayriPage")
            },
            modifier = Modifier
                .padding(start = 30.dp)
                .size(width = 300.dp, height = 50.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = Color.White)
                .background(Color.White)
        ) {
            Text(
                text = "Click Me",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
        }
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Developed by Hitendra",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 80.dp),
            style = TextStyle(
                Color(0xFFE2FADB)
            )
        )

    }
}

   