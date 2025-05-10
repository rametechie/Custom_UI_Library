package com.kpit.demo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kpit.ui_library.*

@Composable
fun DemoScreen() {
    var text by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf("Option 1") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "UI Components", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            text = "Click Me",
            onClick = { /* Handle click */ },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomDropDown(
            options = listOf("Option 1", "Option 2", "Option 3"),
            selectedOption = selected,
            onOptionSelected = { selected = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomInputField(
            label = "Password",
            hint = "Enter password",
            value = text,
            onValueChange = { text = it },
            passwordVisibility = true,
            passwordStrength = ::passwordStrength
        )
    }
}