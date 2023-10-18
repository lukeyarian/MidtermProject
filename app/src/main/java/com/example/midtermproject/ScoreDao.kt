package com.example.midtermproject
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.midtermproject.Score

@Dao
interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(score: Score)

    @Query("SELECT * FROM score_table ORDER BY guesses DESC")
    fun getAllScores(): LiveData<List<Score>>

    @Delete
    suspend fun delete(score: Score)
}