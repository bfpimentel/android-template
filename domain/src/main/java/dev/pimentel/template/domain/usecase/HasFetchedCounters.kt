package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.PreferencesRepository

class HasFetchedCounters(private val repository: PreferencesRepository) :
    SuspendedUseCase<NoParams, Boolean> {

    override suspend fun invoke(params: NoParams): Boolean = repository.hasFetchedCounters()
}
