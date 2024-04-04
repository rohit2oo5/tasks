package com.myapplication

interface Destinations {
    val route: String
}

object Onboarding: Destinations {
    override val route: String = "Onboarding"
}

object Home: Destinations {
    override val route: String = "Home"
}

object SignInScreen: Destinations {
    override val route: String = "SignINScreen"
}