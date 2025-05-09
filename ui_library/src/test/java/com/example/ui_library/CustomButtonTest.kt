package com.example.ui_library

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.graphics.Color
import org.junit.Rule
import org.junit.Test

class CustomButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonDisplaysCorrectTextAndIsClickable() {
        var clicked = false
        composeTestRule.setContent {
            CustomButton(
                text = "Submit",
                onClick = { clicked = true },
                backgroundColor = Color.Blue,
                textColor = Color.White
            )
        }

        composeTestRule.onNodeWithText("Submit").assertExists().performClick()
        assert(clicked)
    }
}