package com.example.midtermproject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HighScoreViewModel(private val repository: ScoreRepository) : ViewModel() {

    //updates of the high scores list from the database.
    val allScores: LiveData<List<Score>> = repository.allScores

     //coroutine to insert the data in a non-blocking way.
    fun insert(score: Score) = viewModelScope.launch {
        repository.insert(score)
    }

     //coroutine to delete the data in a non-blocking way.
    fun delete(score: Score) = viewModelScope.launch {
        repository.delete(score)
    }

}