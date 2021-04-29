package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.PreferencesRepository

class SetHasFetchedCounters(private val repository: PreferencesRepository) :
    SuspendedUseCase<NoParams, Unit> {

    override suspend fun invoke(params: NoParams) = repository.setHasFetchedCounters()
}
