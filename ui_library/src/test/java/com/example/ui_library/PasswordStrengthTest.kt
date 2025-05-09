package com.example.ui_library

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordStrengthTest {

    @Test
    fun testVeryWeakPassword() {
        assertEquals(PasswordStrength.VERY_WEAK, passwordStrength("12345"))
    }

    @Test
    fun testWeakPasswordLettersOnly() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("abcdefgh"))
    }

    @Test
    fun testStrongPasswordMixed() {
        assertEquals(PasswordStrength.STRONG, passwordStrength("Abc123!@#456"))
    }
}