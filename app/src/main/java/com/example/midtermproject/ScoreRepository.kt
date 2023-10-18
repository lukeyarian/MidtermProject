package com.example.midtermproject

import androidx.lifecycle.LiveData

class ScoreRepository(private val scoreDao: ScoreDao) {
    val allScores: LiveData<List<Score>> = scoreDao.getAllScores()
    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }

    suspend fun delete(score: Score) {
        scoreDao.delete(score)
    }
}