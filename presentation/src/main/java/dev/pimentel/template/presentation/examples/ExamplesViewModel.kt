package dev.pimentel.template.presentation.examples

import dev.pimentel.template.R
import dev.pimentel.template.di.NavigatorRouterQualifier
import dev.pimentel.template.domain.usecase.CreateCounter
import dev.pimentel.template.presentation.examples.data.ExamplesIntention
import dev.pimentel.template.presentation.examples.data.ExamplesState
import dev.pimentel.template.presentation.examples.mappers.ExamplesViewDataMapper
import dev.pimentel.template.shared.dispatchers.DispatchersProvider
import dev.pimentel.template.shared.mvi.StateViewModelImpl
import dev.pimentel.template.shared.mvi.toEvent
import dev.pimentel.template.shared.navigator.NavigatorRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExamplesViewModel @Inject constructor(
    @NavigatorRouterQualifier private val navigator: NavigatorRouter,
    private val createCounter: CreateCounter,
    private val mapper: ExamplesViewDataMapper,
    dispatchersProvider: DispatchersProvider,
    @ExamplesStateQualifier initialState: ExamplesState
) : StateViewModelImpl<ExamplesState, ExamplesIntention>(
    dispatchersProvider = dispatchersProvider,
    initialState = initialState
), ExamplesContract.ViewModel {

    override suspend fun handleIntentions(intention: ExamplesIntention) {
        when (intention) {
            is ExamplesIntention.GetExamples -> getExamples()
            is ExamplesIntention.SelectExample -> selectExample(intention.name)
            is ExamplesIntention.Close -> navigator.pop()
        }
    }

    private suspend fun getExamples() {
        updateState { copy(examplesEvent = mapper.getExamples().toEvent()) }
    }

    private suspend fun selectExample(name: String) {
        createCounter(CreateCounter.Params(name))
        navigator.pop(R.id.countersFragment)
    }
}
