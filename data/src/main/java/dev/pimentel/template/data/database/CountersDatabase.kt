package dev.pimentel.template.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.pimentel.template.data.dto.CounterDTO
import dev.pimentel.template.data.sources.local.CountersLocalDataSource

@Database(
    entities = [CounterDTO::class],
    version = 1,
    exportSchema = false
)
abstract class CountersDatabase : RoomDatabase() {

    abstract fun createCountersLocalDataSource(): CountersLocalDataSource
}
