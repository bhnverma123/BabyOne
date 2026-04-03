package com.example.kmplearning

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmplearning.composeapp.generated.resources.Res
import kmplearning.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random
import kotlin.time.Clock

@Composable
@Preview
fun App() {
    var count by remember { mutableStateOf(1) }
    var backgroundColor by remember {
        mutableStateOf(generateDarkColor())
    }
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(backgroundColor)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                modifier = Modifier.width(400.dp).height(70.dp),
                onClick = {
                    backgroundColor = generateDarkColor()
                    showContent = !showContent
                    if (count == 10) {
                        count = 0
                    }
                    count++

                }) {
                Text("Click me!", fontSize = 50.sp,)
            }
            Text(
                "$count",
                style = MaterialTheme.typography.labelLarge,
                fontSize = 600.sp,
                fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                color = Color.White
            )
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }


}

fun generateDarkColor(): Color {
    val random = Random(Clock.System.now().toEpochMilliseconds())

    // Keep values low to ensure dark shades
    val red = random.nextInt(0, 100)
    val green = random.nextInt(0, 100)
    val blue = random.nextInt(0, 100)

    return Color(red, green, blue)
}