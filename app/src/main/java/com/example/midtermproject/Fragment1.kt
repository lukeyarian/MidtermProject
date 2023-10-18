package com.example.midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Fragment1 : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment1_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)

        //view.findViewById<ImageButton>(R.id.minusButton).setOnClickListener {
            //adjustGuess(-1)
        //}

        //view.findViewById<ImageButton>(R.id.plusButton).setOnClickListener {
            //adjustGuess(1)
        //}

        view.findViewById<Button>(R.id.okButton).setOnClickListener {
            val guessEditText = view.findViewById<EditText>(R.id.guessEditText)
            val guess = guessEditText.text.toString().toIntOrNull()

            if (guess != null) {
                viewModel.makeGuess("Player", guess) // Assuming "Player" as a placeholder name.
                guessEditText.text.clear()
            } else {
                Toast.makeText(context, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun adjustGuess(amount: Int) {
        val guessEditText = view?.findViewById<EditText>(R.id.guessEditText)
        var guess = guessEditText?.text.toString().toIntOrNull() ?: 0
        guess += amount

        if (guess in 1..100) {
            guessEditText?.setText(guess.toString())
        }
    }
}