package com.sevens.brkipedia.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sevens.brkipedia.R
import com.sevens.brkipedia.databinding.ItemFamousQuoteBinding
import com.sevens.brkipedia.domain.models.DomainQuote

class DetailQuotesAdapter(private val listener: ((DomainQuote) -> Unit)?
) : ListAdapter<DomainQuote, DetailQuotesAdapter.QuoteViewHolder>(DiffQuoteCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val season = getItem(position)
        holder.bind(season)
        holder.itemView.setOnClickListener { listener?.invoke(season) }
    }

    class QuoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemFamousQuoteBinding.bind(itemView)

        fun bind(quote: DomainQuote) = with(binding){
            quoteText.text = quote.text
        }

        companion object{
            fun create(parent: ViewGroup): QuoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_famous_quote, parent, false)
                return QuoteViewHolder(view)
            }
        }
    }

}

class DiffQuoteCallback: DiffUtil.ItemCallback<DomainQuote>() {

    override fun areItemsTheSame(oldItem: DomainQuote, newItem: DomainQuote): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DomainQuote, newItem: DomainQuote): Boolean {
        return oldItem == newItem
    }
}