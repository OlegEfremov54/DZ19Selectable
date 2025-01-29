package com.example.dz19selectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dz19selectable.ui.theme.DZ19SelectableTheme


class FinishActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DZ19SelectableTheme {

                val primaryColor = MaterialTheme.colorScheme.secondary

                Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize(),) {
                    Column (modifier = Modifier.height(300.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween) {
                        Box(modifier = Modifier.clip(CircleShape).background(primaryColor).padding(32.dp, 8.dp)) {
                            Text(text = "Правильных ответов: ${intent.extras!!.getInt("points")}",
                                fontSize = 24.sp,
                                color = Color.Black)
                        }
                        Button(
                            modifier = Modifier.padding(10.dp),
                            onClick = {
                                val intent = Intent(this@FinishActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        ) {
                            Text("Начать сначала!")

                        }
                        Spacer(modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp))

                        Button(
                            modifier = Modifier.padding(10.dp),
                            onClick = {
                                finish()
                            }
                        ) {
                            Text("Завершить тест!")

                        }
                    }
                }
            }
        }
    }
}