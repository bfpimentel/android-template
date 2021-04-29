package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.CountersRepository
import dev.pimentel.template.domain.usecase.SearchCounters
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class SearchCountersTest {

    private val countersRepository = mockk<CountersRepository>()
    private val useCase = SearchCounters(countersRepository)

    @Test
    fun `should search counters`() = runBlockingTest {
        val query = "query"

        coJustRun { countersRepository.searchCounters(query) }

        useCase(SearchCounters.Params(query))

        coVerify(exactly = 1) { countersRepository.searchCounters(query) }
        confirmVerified(countersRepository)
    }
}
