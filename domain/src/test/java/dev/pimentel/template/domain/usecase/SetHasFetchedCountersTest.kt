package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.PreferencesRepository
import dev.pimentel.template.domain.usecase.NoParams
import dev.pimentel.template.domain.usecase.SetHasFetchedCounters
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class SetHasFetchedCountersTest {

    private val repository = mockk<PreferencesRepository>()
    private val useCase = SetHasFetchedCounters(repository)

    @Test
    fun `should just call repository`() = runBlockingTest {
        coJustRun { repository.setHasFetchedCounters() }

        useCase(NoParams)

        coVerify(exactly = 1) { repository.setHasFetchedCounters() }
        confirmVerified(repository)
    }
}
