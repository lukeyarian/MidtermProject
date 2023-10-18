package com.example.midtermproject

import android.app.GameState
import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel(private val repository: ScoreRepository) : ViewModel() {
    private val _randomNumber = MutableLiveData<Int>(Random.nextInt(1, 101))
    val guessCount = MutableLiveData<Int>(0)
    val gameStateMessage = MutableLiveData<String>()

    fun makeGuess(playerName: String, guess: Int) {
        val randomNumberValue = _randomNumber.value ?: return
        guessCount.value = (guessCount.value ?: 0) + 1

        when {
            guess == randomNumberValue -> {
                gameStateMessage.value = "Correct!"
                saveScore(playerName, guessCount.value ?: 0)
            }
            guess < randomNumberValue -> {
                gameStateMessage.value = "Too low!"
                //play incorrect sound
                //playSound()
            }
            else -> {
                gameStateMessage.value = "Too high!"
                //play incorrect sound
                //playSound()
            }
        }
    }

    private fun saveScore(name: String, guesses: Int) {
        viewModelScope.launch {
            val score = Score(0, playerName = name, guesses = guesses)
            repository.insert(score)
        }
    }

    //private fun playSound() {
        //val mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.wrong)
        //mediaPlayer.start()
        //mediaPlayer.setOnCompletionListener {
            //it.release()
        //}
   // }

    // Call this function to clear the game state message
    fun clearGameStateMessage() {
        gameStateMessage.value = ""
    }
}