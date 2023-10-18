package com.example.midtermproject

import android.app.GameState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class GameViewModel : ViewModel() {
    enum class GameState {
        ONGOING,
        FINISHED
    }

    val gameState = MutableLiveData<GameState>()
    private val randomNumber = (1..100).random()
    private val _guessCount = MutableLiveData<Int>(0)
    val guessCount: LiveData<Int> get() = _guessCount
    fun makeGuess(guess: Int) {
        _guessCount.value = (_guessCount.value ?: 0) + 1

        if (guess == randomNumber) {
            // Handle correct guess
            // Save score to database, navigate away, etc.
        } else {
            // Handle incorrect guess
            // You might want to update some LiveData to display a message to the user
        }
    }
}