package com.kpit.ui_library

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.*

/**
 * A custom password input field component with optional visibility toggle and strength indicator.
 *
 * This composable is useful for password inputs where you want to:
 * - Show/hide the entered password.
 * - Display the strength of the entered password.
 *
 * @param label The label to display above the input field.
 * @param hint The placeholder text shown when the input is empty.
 * @param value The current text entered in the input field.
 * @param onValueChange Callback invoked when the user changes the text.
 * @param passwordVisibility If true, the password is visible by default (toggleable via icon).
 * @param passwordStrength A function that takes the password string and returns a [PasswordStrength] value.
 *
 * Behavior:
 * - Clicking the trailing icon toggles password visibility.
 * - Password strength is shown only if `passwordVisibility` is true.
 * - Strength text is color-coded: red (very weak), gray (weak), green (strong).
 */
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
            modifier = Modifier.testTag("passwordInput"),
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