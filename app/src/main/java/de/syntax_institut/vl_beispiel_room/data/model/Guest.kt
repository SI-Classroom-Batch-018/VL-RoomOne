package de.syntax_institut.vl_beispiel_room.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Guest(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String,
    val food: String
)