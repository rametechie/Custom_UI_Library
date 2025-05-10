package com.kpit.ui_library

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color
) {
    var isClicked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isClicked = !isClicked
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isClicked) backgroundColor.copy(alpha = 0.5f) else backgroundColor.copy(alpha = 0.9f)
        ),
        shape = RoundedCornerShape(12.dp),
        interactionSource = remember { MutableInteractionSource() }
    ) {
        Text(text = text, color = textColor)
    }
}