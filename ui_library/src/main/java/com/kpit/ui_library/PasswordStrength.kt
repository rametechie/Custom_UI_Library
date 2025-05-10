package com.kpit.ui_library

enum class PasswordStrength {
    VERY_WEAK, WEAK, STRONG
}

fun passwordStrength(password: String): PasswordStrength {
    return when {
        password.length < 8 -> PasswordStrength.VERY_WEAK
        password.length in 8..12 && (password.all { it.isLetter() } || password.all { it.isDigit() }) ->
            PasswordStrength.WEAK
        password.length >= 12 && password.any { it.isLetter() } &&
            password.any { it.isDigit() } &&
            password.any { !it.isLetterOrDigit() } -> PasswordStrength.STRONG
        else -> PasswordStrength.WEAK
    }
}