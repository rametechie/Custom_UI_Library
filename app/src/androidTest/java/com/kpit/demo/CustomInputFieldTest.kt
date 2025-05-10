package com.kpit.demo

import androidx.compose.runtime.*
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.kpit.ui_library.CustomInputField
import com.kpit.ui_library.passwordStrength
import org.junit.Rule
import org.junit.Test

class CustomInputFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun inputFieldDisplaysLabelAndUpdatesValue() {
        composeTestRule.setContent {
            var text by remember { mutableStateOf("") }
            CustomInputField(
                label = "Password",
                hint = "Enter password",
                value = text,
                onValueChange = { text = it },
                passwordVisibility = true,
                passwordStrength = ::passwordStrength
            )
        }

        composeTestRule.onNodeWithText("Password").assertExists()
        composeTestRule.onNodeWithText("Enter password").performTextInput("12345678")
        composeTestRule.onNodeWithText("Strength: WEAK").assertExists()
    }
}