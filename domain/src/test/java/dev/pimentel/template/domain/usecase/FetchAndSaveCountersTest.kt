package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository
import dev.pimentel.template.domain.usecase.FetchAndSaveCounters
import dev.pimentel.template.domain.usecase.NoParams
import dev.pimentel.template.domain.usecase.SetHasFetchedCounters
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class FetchAndSaveCountersTest {

    private val repository = mockk<CountersRepository>()
    private val setHasFetchedCounters = mockk<SetHasFetchedCounters>()
    private val useCase = FetchAndSaveCounters(repository, setHasFetchedCounters)

    @Test
    fun `should call repository and then set that has fetched counters`() = runBlockingTest {
        coJustRun { repository.fetchAndSaveCounters() }
        coJustRun { setHasFetchedCounters(NoParams) }

        useCase(NoParams)

        coVerify(exactly = 1) {
            repository.fetchAndSaveCounters()
            setHasFetchedCounters(NoParams)
        }
        confirmVerified(repository, setHasFetchedCounters)
    }
}
