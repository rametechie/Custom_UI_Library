package com.kpit.demo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.kpit.ui_library.*

@Composable
fun DemoScreen() {
    var text by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Custom UI Demo",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        CustomButton(
            text = "Click Me",
            onClick = { /* Handle click */ },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )

        CustomDropDown(
            options = listOf("Option 1", "Option 2", "Option 3"),
            selectedOption = selected,
            onOptionSelected = { selected = it }
        )

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