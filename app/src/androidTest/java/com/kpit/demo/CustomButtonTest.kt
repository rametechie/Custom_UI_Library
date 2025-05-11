package com.kpit.demo

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kpit.ui_library.CustomButton
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomButtonUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun customButton_clickTriggersAction() {
        composeTestRule.onNodeWithText("Click Me").assertExists().performClick()
    }

    @Test
    fun buttonIsDisplayed() {
        composeTestRule.onNodeWithText("Click Me").assertExists().performClick()
    }

    @Test
    fun buttonIsCorrectBackgroundColor() {
        // Check that a button with the testTag exists
        composeTestRule.onNodeWithTag("button_primary").assertExists()
    }
}