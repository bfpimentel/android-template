package dev.pimentel.template.presentation.examples

import dev.pimentel.template.presentation.examples.data.ExamplesIntention
import dev.pimentel.template.presentation.examples.data.ExamplesState
import dev.pimentel.template.shared.mvi.StateViewModel

interface ExamplesContract {

    interface ViewModel : StateViewModel<ExamplesState, ExamplesIntention>

    fun interface ItemListener {
        fun onExampleClick(name: String)
    }
}
