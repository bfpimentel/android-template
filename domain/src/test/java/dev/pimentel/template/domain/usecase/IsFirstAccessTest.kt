package dev.pimentel.template.domain.usecase

import dev.pimentel.template.domain.repository.PreferencesRepository
import dev.pimentel.template.domain.usecase.HasFetchedCounters
import dev.pimentel.template.domain.usecase.NoParams
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IsFirstAccessTest {

    private val repository = mockk<PreferencesRepository>()
    private val useCase = HasFetchedCounters(repository)

    @Test
    fun `should return repository answer`() = runBlockingTest {
        val isFirstAccess = true

        coEvery { repository.hasFetchedCounters() } returns isFirstAccess

        assertEquals(useCase(NoParams), isFirstAccess)

        coVerify(exactly = 1) { repository.hasFetchedCounters() }
        confirmVerified(repository)
    }
}
