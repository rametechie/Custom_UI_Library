package com.kpit.demo

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomDropDownUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun dropdown_SelectsNewOption() {
        // Initial state
        composeTestRule.onNodeWithText("Select an option").assertExists().performClick()

        // Select an item from the dropdown
        composeTestRule.onNodeWithText("Option 2").performClick()

        // Verify the selection updated
        composeTestRule.onNodeWithText("Option 2").assertExists()
    }
}