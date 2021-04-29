package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository
import dev.pimentel.template.domain.usecase.IncreaseCount
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class IncreaseCountTest {

    private val countersRepository = mockk<CountersRepository>()
    private val useCase = IncreaseCount(countersRepository)

    @Test
    fun `should increase count`() = runBlockingTest {
        val counterId = "counterId"

        coJustRun { countersRepository.increaseCount(counterId) }

        useCase(IncreaseCount.Params(counterId))

        coVerify(exactly = 1) { countersRepository.increaseCount(counterId) }
        confirmVerified(countersRepository)
    }
}
