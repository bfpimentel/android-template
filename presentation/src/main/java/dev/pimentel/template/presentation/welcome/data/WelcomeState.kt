package dev.pimentel.template.presentation.welcome.data

import dev.pimentel.template.shared.mvi.Event

data class WelcomeState(
    val isButtonEnabled: Boolean = true,
    val errorEvent: Event<Unit>? = null
)
