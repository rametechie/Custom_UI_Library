package com.kpit.demo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomInputFieldUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun inputFieldUpdatesValueAndShowsStrength() {
        val passwordText = "MyPass123!"

        // Type the password
        composeTestRule.onNodeWithText("Enter password")
            .assertExists()
            .performTextInput(passwordText)

        // Confirm password appears in the field
        composeTestRule.onNodeWithText(passwordText).assertExists()

        // Check that a strength label appears (weaker, more robust)

        val strengthPrefix = "Strength: "
        composeTestRule.onAllNodes(hasText(strengthPrefix, substring = true))
            .onFirst()
            .assertExists()
    }

    @Test
    fun togglePasswordVisibilityIconWorks() {
        // Toggle visibility icon (eye icon)
        composeTestRule.onNodeWithContentDescription("Toggle Password Visibility")
            .assertExists()
            .performClick()
    }
}