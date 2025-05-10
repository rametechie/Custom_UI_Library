package com.kpit.ui_library

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

    @Test
    fun testWeakPasswordNumbersOnly() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("12345678"))
    }

    @Test
    fun testWeakPasswordMixedButShort() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("abc123!!"))  // 9 chars, not strong
    }

    @Test
    fun testExactly8CharsLettersOnly() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("abcdefgh"))
    }

    @Test
    fun testExactly12CharsWithoutSymbols() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("Abcdef123456")) // No special characters
    }

    @Test
    fun testEmptyPassword() {
        assertEquals(PasswordStrength.VERY_WEAK, passwordStrength(""))
    }

    @Test
    fun testStrongPasswordJustAtLimit() {
        assertEquals(PasswordStrength.STRONG, passwordStrength("A1!A1!A1!A1!")) // Exactly 12 chars, meets all rules
    }

    @Test
    fun testLongPasswordMissingDigit() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("Abcdef!!@#XYZ")) // no digit
    }

    @Test
    fun testLongPasswordMissingLetter() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("1234!@#123456")) // no letter
    }

    @Test
    fun testLengthBetween8And11WithMixedChars() {
        assertEquals(PasswordStrength.WEAK, passwordStrength("abc123xyz"))
    }
}