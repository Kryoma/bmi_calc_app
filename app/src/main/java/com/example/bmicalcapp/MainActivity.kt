package com.example.bmicalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalcapp.ui.theme.BMICalcAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalcAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = "BMI計算アプリ",
                            fontSize = 26.sp, fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        // 身長
                        PinkLabeledTextField(
                            value = "",
                            onValueChange = {},
                            label = "身長(cm)",
                            placeHolder = "170"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        PinkLabeledTextField(
                            value = "",
                            onValueChange = {},
                            label = "体重(kg)",
                            placeHolder = "65"
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF85f6A)
                            )
                        )
                        {
                            Text(
                                text = "計算する",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        // 結果表示テキスト
                        Text(
                            text = "あなたのBMIは0です",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                    }

                }
            }
        }
    }
}

@Composable
fun PinkLabeledTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeHolder: String
) {
    Column {
        Text(
            text = label,
            color = Color(0xFFF85f6A), fontWeight = FontWeight.Bold
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            placeholder = { Text(text = placeHolder) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }
}