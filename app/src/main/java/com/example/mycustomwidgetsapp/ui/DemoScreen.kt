package com.example.mycustomwidgetsapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui_library.*

@Composable
fun DemoScreen() {
    var text by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf("Option 1") }

    Column(modifier = Modifier.padding(16.dp)) {
        CustomButton(
            text = "Click Me",
            onClick = { /* Handle click */ },
            backgroundColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.onPrimary
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