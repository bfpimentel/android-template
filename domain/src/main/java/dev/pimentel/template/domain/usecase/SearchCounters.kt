package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository

class SearchCounters(private val repository: CountersRepository) :
    SuspendedUseCase<SearchCounters.Params, Unit> {

    override suspend fun invoke(params: Params) {
        repository.searchCounters(query = params.query)
    }

    data class Params(val query: String?)
}
