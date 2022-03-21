package com.sevens.brkipedia.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sevens.brkipedia.R
import com.sevens.brkipedia.databinding.ItemSeasonBinding

class DetailSeasonsAdapter(private val listener: ((Int) -> Unit)?
) : ListAdapter<Int, DetailSeasonsAdapter.SeasonViewHolder>(DiffSeasonCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val season = getItem(position)
        holder.bind(season)
        holder.itemView.setOnClickListener { listener?.invoke(season) }
    }

    class SeasonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemSeasonBinding.bind(itemView)
        fun bind(season: Int) = with(binding){
            seasonNumberText.text = season.toString()
        }

        companion object{
            fun create(parent: ViewGroup): SeasonViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_season, parent, false)
                return SeasonViewHolder(view)
            }
        }
    }

}

class DiffSeasonCallback: DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}