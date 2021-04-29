package dev.pimentel.template.data.model

import dev.pimentel.template.domain.model.CounterModel

data class CounterModelImpl(
    override val id: String,
    override val title: String,
    override val count: Int
) : CounterModel
