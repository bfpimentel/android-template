package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository

class IncreaseCount(private val repository: CountersRepository) :
    SuspendedUseCase<IncreaseCount.Params, Unit> {

    override suspend fun invoke(params: Params) = repository.increaseCount(params.counterId)

    data class Params(val counterId: String)
}
