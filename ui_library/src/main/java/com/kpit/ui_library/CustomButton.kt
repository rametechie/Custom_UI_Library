package com.kpit.ui_library

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
// click effect
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor)
    )
    {
        Text(text = text, color = textColor)
    }
}

