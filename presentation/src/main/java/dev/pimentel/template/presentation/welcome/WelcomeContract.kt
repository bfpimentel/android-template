package dev.pimentel.template.presentation.welcome

import dev.pimentel.template.presentation.welcome.data.WelcomeIntention
import dev.pimentel.template.presentation.welcome.data.WelcomeState
import dev.pimentel.template.shared.mvi.StateViewModel

interface WelcomeContract {

    interface ViewModel : StateViewModel<WelcomeState, WelcomeIntention>
}
