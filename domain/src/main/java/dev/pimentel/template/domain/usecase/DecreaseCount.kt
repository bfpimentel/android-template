package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository

class DecreaseCount(private val repository: CountersRepository) :
    SuspendedUseCase<DecreaseCount.Params, Unit> {

    override suspend fun invoke(params: Params) = repository.decreaseCount(params.counterId)

    data class Params(val counterId: String)
}
