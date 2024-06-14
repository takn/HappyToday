package com.nelson.ramirez.happytoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nelson.ramirez.happytoday.ui.theme.HappyTodayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyTodayTheme {
                val navController = rememberNavController()
                HappyTodayApp(
                    navController = navController
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    HappyTodayTheme {
        HappyTodayApp(rememberNavController())
    }
}