package de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbUserName(
    @PrimaryKey
    val id: Int = 0,
    val text: String
)
