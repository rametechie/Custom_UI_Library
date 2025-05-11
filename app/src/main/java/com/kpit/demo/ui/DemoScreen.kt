package com.kpit.demo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kpit.demo.viewmodel.DemoViewModel
import com.kpit.ui_library.*

@Composable
fun DemoScreen(viewModel: DemoViewModel = viewModel()) {
    val text by viewModel.text.collectAsState()
    val selected by viewModel.selected.collectAsState()

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

        CustomInputField(
            label = "Password",
            hint = "Enter password",
            value = text,
            onValueChange = { viewModel.onTextChanged(it) },
            passwordVisibility = true,
            passwordStrength = ::passwordStrength
        )

        CustomDropDown(
            options = listOf("Option 1", "Option 2", "Option 3"),
            selectedOption = selected,
            onOptionSelected = { viewModel.onSelectionChanged(it) }
        )

        CustomButton(
            text = "Click Me",
            onClick = {
                // example action
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
    }
}
