package dev.pimentel.template.presentation.create_counter

import dev.pimentel.template.presentation.create_counter.data.CreateCounterIntention
import dev.pimentel.template.presentation.create_counter.data.CreateCounterState
import dev.pimentel.template.shared.mvi.StateViewModel

interface CreateCounterContract {

    interface ViewModel : StateViewModel<CreateCounterState, CreateCounterIntention>
}
