package com.myapplication

import androidx.lifecycle.ViewModel
import com.myapplication.presentation.sign_in.SignInResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()


    fun onSignInResult(result: SignInResult) {
        _state.update { it.copy(
            isSignInSucessful = result.data != null,
            signInError = result.errorMessage
        )}
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}