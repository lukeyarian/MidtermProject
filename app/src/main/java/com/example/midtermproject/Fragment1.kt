package com.example.midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Fragment1 : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment1_layout, container, false)

        viewModel = ViewModelProvider(requireParentFragment()).get(GameViewModel::class.java)

        view.findViewById<Button>(R.id.okButton).setOnClickListener {
            val userGuess = view.findViewById<EditText>(R.id.guessEditText).text.toString().toInt()
            viewModel.makeGuess(userGuess)
        }

        return view
    }
}