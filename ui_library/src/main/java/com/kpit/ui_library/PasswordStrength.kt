package com.kpit.ui_library

/**
 * Enum class representing levels of password strength.
 *
 * - VERY_WEAK: Password is too short (less than 8 characters).
 * - WEAK: Password is of moderate length but lacks complexity.
 * - STRONG: Password is long and includes letters, digits, and special characters.
 */
enum class PasswordStrength {
    VERY_WEAK, WEAK, STRONG
}

/**
 * Evaluates the strength of a password based on its length and character composition.
 *
 * @param password The password string to be evaluated.
 * @return [PasswordStrength] indicating whether the password is VERY_WEAK, WEAK, or STRONG.
 *
 * Evaluation Criteria:
 * - VERY_WEAK: Password is less than 8 characters.
 * - WEAK: Password is 8–12 characters long and contains only letters or only digits.
 * - STRONG: Password is at least 12 characters long, contains at least one letter,
 *   one digit, and one special character.
 * - All other cases are considered WEAK.
 */
fun passwordStrength(password: String): PasswordStrength {
    return when {
        // Case 1: Password is shorter than 8 characters
        password.length < 8 -> PasswordStrength.VERY_WEAK
        // Case 2: Password is between 8 and 12 characters and contains only letters or only digits
        password.length in 8..12 && (password.all { it.isLetter() } || password.all { it.isDigit() }) ->
            PasswordStrength.WEAK
        // Case 3: Password is 12 or more characters and contains a letter, digit, and special character
        password.length >= 12 && password.any { it.isLetter() } &&
                password.any { it.isDigit() } &&
                password.any { !it.isLetterOrDigit() } -> PasswordStrength.STRONG
        // Case 4: Any other password format falls into WEAK category
        else -> PasswordStrength.WEAK
    }
}