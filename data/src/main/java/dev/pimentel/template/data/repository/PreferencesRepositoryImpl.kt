package dev.pimentel.template.data.repository

import dev.pimentel.template.data.sources.local.PreferencesLocalDataSource
import dev.pimentel.template.domain.repository.PreferencesRepository

class PreferencesRepositoryImpl(
    private val preferencesLocalDataSource: PreferencesLocalDataSource
) : PreferencesRepository {

    override suspend fun hasFetchedCounters(): Boolean = preferencesLocalDataSource.hasFetchedCounters()

    override suspend fun setHasFetchedCounters() = preferencesLocalDataSource.setHasFetchedCounters()
}
