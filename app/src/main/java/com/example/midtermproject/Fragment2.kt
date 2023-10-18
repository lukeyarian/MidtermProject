package com.example.midtermproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class Fragment2 : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment2_layout, container, false)

        viewModel = ViewModelProvider(requireParentFragment()).get(GameViewModel::class.java)

        viewModel.guessCount.observe(viewLifecycleOwner, Observer { attempts ->
            view.findViewById<TextView>(R.id.attemptsTextView).text = "Attempts: $attempts"
        })

        return view
    }
}