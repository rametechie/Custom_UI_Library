package com.kpit.demo


import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kpit.ui_library.CustomDropDown
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomDropDownTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

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