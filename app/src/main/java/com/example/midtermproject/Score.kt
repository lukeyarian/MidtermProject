package com.example.midtermproject
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val playerName: String,
    val guesses: Int
)