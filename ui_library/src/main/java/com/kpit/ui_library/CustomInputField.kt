package com.kpit.ui_library

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.*

@Composable
fun CustomInputField(
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    passwordVisibility: Boolean,
    passwordStrength: (String) -> PasswordStrength
) {
    var visible by remember { mutableStateOf(passwordVisibility) }
    val visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation()
    val strength = passwordStrength(value)

    Column {
        Text(text = label)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(hint) },
            visualTransformation = visualTransformation,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { visible = !visible }) {
                    Icon(
                        imageVector = if (visible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Toggle Password Visibility",
                        tint = Color.Gray
                    )
                }
            }
        )
        if (passwordVisibility) {
            Text("Strength: ${strength.name}", color = when (strength) {
                PasswordStrength.VERY_WEAK -> Color.Red
                PasswordStrength.WEAK -> Color.Gray
                PasswordStrength.STRONG -> Color.Green
            })
        }
    }
}