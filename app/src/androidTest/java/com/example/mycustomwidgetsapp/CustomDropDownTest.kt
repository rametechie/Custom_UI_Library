package com.example.mycustomwidgetsapp


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.ui_library.CustomDropDown
import org.junit.Rule
import org.junit.Test

class CustomDropDownTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dropdownUpdatesSelectedOption() {
        val options = listOf("One", "Two", "Three")
        var selected = "One"

        composeTestRule.setContent {
            CustomDropDown(
                options = options,
                selectedOption = selected,
                onOptionSelected = { selected = it }
            )
        }

        composeTestRule.onNodeWithText("One").performClick()
        composeTestRule.onNodeWithText("Two").performClick()
        assert(selected == "Two")
    }
}