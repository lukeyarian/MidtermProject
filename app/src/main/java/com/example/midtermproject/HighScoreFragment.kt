package com.example.midtermproject
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermproject.HighScoreAdapter
class HighScoreFragment : Fragment() {
    private lateinit var viewModel: HighScoreViewModel
    private lateinit var adapter: HighScoreAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_high_score, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = view.findViewById(R.id.highScoresRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[HighScoreViewModel::class.java]

        adapter = HighScoreAdapter { score ->
            //delete confirmation here
            showDeleteConfirmationDialog(score)
        }
        recyclerView.adapter = adapter

        viewModel.allScores.observe(viewLifecycleOwner) { scores ->
            scores?.let {
                adapter.submitList(scores.sortedByDescending { it.guesses })
            }
        }
    }
    private fun showDeleteConfirmationDialog(score: Score) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.apply {
            setTitle("Delete Score")
            setMessage("Are you sure you want to delete this score?")
            setPositiveButton("Delete") { dialog, id ->
                viewModel.delete(score)
                Toast.makeText(context, "Score deleted", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancel") { dialog, id ->
                dialog.dismiss()
            }
        }
        alertDialogBuilder.create().show()
    }
}