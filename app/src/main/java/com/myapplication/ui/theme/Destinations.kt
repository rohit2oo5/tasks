package com.myapplication.ui.theme

interface Destinations {
    val route: String
}

object Onboarding: Destinations {
    override val route: String = "Onboarding"
}