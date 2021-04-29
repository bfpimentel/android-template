package dev.pimentel.template.presentation.counters.mappers

import android.content.Context
import dev.pimentel.template.R
import dev.pimentel.template.domain.entity.Counter

interface CountersDeletionMapper {
    fun map(itemsToBeDeleted: List<Counter>): String
}

class CountersDeletionMapperImpl(private val context: Context) : CountersDeletionMapper {

    override fun map(itemsToBeDeleted: List<Counter>): String =
        when (itemsToBeDeleted.size) {
            0 -> throw IllegalArgumentException("List can't be empty")
            1 -> context.getString(
                R.string.counters_delete_confirmation_question_one_item,
                itemsToBeDeleted[0].title
            )
            else -> context.getString(
                R.string.counters_delete_confirmation_question_more_items,
                itemsToBeDeleted.dropLast(1).joinToString(transform = Counter::title),
                itemsToBeDeleted.last().title
            )
        }
}
