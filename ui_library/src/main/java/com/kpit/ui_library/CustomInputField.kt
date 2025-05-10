package com.kpit.ui_library

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
//hint is not visible
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
    val strength = passwordStrength(value)

    Column {
        Text(text = label)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = hint) },
            visualTransformation = if (!visible && passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
            /*trailingIcon = {
                if (passwordVisibility) {
                    IconButton(onClick = { visible = !visible }) {
                        //Icon(Icons.Default.Visibility, contentDescription = null)
                    }
                }
            }*/
        )
        if (passwordVisibility) {
            Text("Strength: ${strength.name}", color = when (strength) {
                PasswordStrength.VERY_WEAK -> Color.Red
                PasswordStrength.WEAK -> Color.Yellow
                PasswordStrength.STRONG -> Color.Green
            })
        }
    }
}