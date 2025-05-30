
package com.kpit.ui_library

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

/**
 * A generic custom dropdown menu component built with Jetpack Compose.
 *
 * Displays a clickable container that shows a list of options in a dropdown format.
 * When an option is selected, the menu closes and the selection is updated via callback.
 *
 * @param options A list of items of any type to display in the dropdown menu.
 * @param selectedOption The currently selected item, which is shown as the default text.
 * @param onOptionSelected A lambda callback invoked when the user selects an item.
 */
@Composable
fun <T> CustomDropDown(
    options: List<T>,
    selectedOption: T?,
    onOptionSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { expanded = !expanded }
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = selectedOption?.toString() ?: "Select an option")
            Icon(
                imageVector = if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.toString()) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    modifier = Modifier
                        .background(
                            if (option == selectedOption) Color(0xFFE0E0E0) else Color.Transparent,
                            shape = RoundedCornerShape(12.dp)
                        )
                )
            }
        }
    }
}
