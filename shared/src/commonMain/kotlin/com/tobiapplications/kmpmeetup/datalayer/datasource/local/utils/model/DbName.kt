package com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbName(
    @PrimaryKey
    val id: Int = 0,
    val text: String
)
