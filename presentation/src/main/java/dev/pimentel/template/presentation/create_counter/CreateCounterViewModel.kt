package dev.pimentel.template.presentation.create_counter

import dev.pimentel.template.di.NavigatorRouterQualifier
import dev.pimentel.template.domain.usecase.CreateCounter
import dev.pimentel.template.presentation.create_counter.data.CreateCounterIntention
import dev.pimentel.template.presentation.create_counter.data.CreateCounterState
import dev.pimentel.template.shared.dispatchers.DispatchersProvider
import dev.pimentel.template.shared.mvi.StateViewModelImpl
import dev.pimentel.template.shared.navigator.NavigatorRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateCounterViewModel @Inject constructor(
    @NavigatorRouterQualifier private val navigator: NavigatorRouter,
    private val createCounter: CreateCounter,
    dispatchersProvider: DispatchersProvider,
    @CreateCounterStateQualifier initialState: CreateCounterState
) : StateViewModelImpl<CreateCounterState, CreateCounterIntention>(
    dispatchersProvider = dispatchersProvider,
    initialState = initialState
), CreateCounterContract.ViewModel {

    private lateinit var name: String

    override suspend fun handleIntentions(intention: CreateCounterIntention) {
        when (intention) {
            is CreateCounterIntention.SetName -> setName(intention.name)
            is CreateCounterIntention.Save -> save()
            is CreateCounterIntention.NavigateToExamples -> navigateToExamples()
            is CreateCounterIntention.Close -> navigator.pop()
        }
    }

    private suspend fun setName(name: String) {
        this.name = name
        updateState { copy(canSave = name.isNotEmpty()) }
    }

    private suspend fun save() {
        createCounter(CreateCounter.Params(name))
        navigator.pop()
    }

    private suspend fun navigateToExamples() {
        val directions = CreateCounterFragmentDirections.toExamplesFragment()
        navigator.navigate(directions)
    }
}
