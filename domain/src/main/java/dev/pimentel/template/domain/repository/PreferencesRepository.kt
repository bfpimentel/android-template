package dev.pimentel.template.domain.repository

interface PreferencesRepository {
    suspend fun hasFetchedCounters(): Boolean
    suspend fun setHasFetchedCounters()
}
