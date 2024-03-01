package com.myapplication

data class SignInState (
    val isSignInSucessful: Boolean = false,
    val signInError: String? = null
)