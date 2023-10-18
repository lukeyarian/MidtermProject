package com.example.midtermproject
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermproject.Score
import com.example.midtermproject.databinding.RecyclerViewItemBinding
class HighScoreAdapter(private val onDeleteClick: (Score) -> Unit) :
    ListAdapter<Score, HighScoreAdapter.ViewHolder>(ScoreDiffCallback()) {
    inner class ViewHolder(private val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(score: Score) {
            binding.apply {
                playerNameTextView.text = score.playerName
                scoreTextView.text = score.guesses.toString()
                deleteButton.setOnClickListener {
                    onDeleteClick(score)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val score = getItem(position)
        holder.bind(score)
    }
class ScoreDiffCallback : DiffUtil.ItemCallback<Score>() {
    override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem == newItem
    }
} }
