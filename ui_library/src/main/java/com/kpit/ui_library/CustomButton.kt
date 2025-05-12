package com.kpit.ui_library

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

/**
 * A reusable and customizable button component built with Jetpack Compose and Material 3 styling.
 *
 * This button supports theming, custom colors, rounded corners, and testing tags for UI testing.
 *
 * @param text The label text to display inside the button.
 * @param onClick A lambda function triggered when the button is clicked.
 * @param backgroundColor The color used for the button background.
 * @param textColor The color used for the button label text.
 * @param modifier Optional [Modifier] for layout or interaction behavior. Defaults to [Modifier].
 *
 * The button automatically sets a `testTag` for testing purposes:
 * - `"button_primary"` if the background color matches the theme's primary color.
 * - `"customButton"` for all other background colors.
 *
 * The button also applies a rounded corner shape with a radius of 12.dp.
 */
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    val tag = when (backgroundColor) {
        MaterialTheme.colorScheme.primary -> "button_primary"
        else -> "customButton"
    }

    Button(
        onClick = onClick,
        modifier = modifier.testTag(tag),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text, color = textColor)
    }
}