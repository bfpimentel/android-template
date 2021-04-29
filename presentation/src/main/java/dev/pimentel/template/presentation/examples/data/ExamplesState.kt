package dev.pimentel.template.presentation.examples.data

import dev.pimentel.template.shared.mvi.Event

data class ExamplesState(
    val examplesEvent: Event<List<ExampleViewData>>? = null
)
