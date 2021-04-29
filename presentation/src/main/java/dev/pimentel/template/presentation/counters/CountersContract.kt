package dev.pimentel.template.presentation.counters

import dev.pimentel.template.presentation.counters.data.CountersIntention
import dev.pimentel.template.presentation.counters.data.CountersState
import dev.pimentel.template.shared.mvi.StateViewModel

interface CountersContract {

    interface ViewModel : StateViewModel<CountersState, CountersIntention>

    interface ItemListener {
        fun onCounterLongClick(counterId: String)
        fun onCounterClick(counterId: String)
        fun onIncreaseClick(counterId: String)
        fun onDecreaseClick(counterId: String)
    }
}
