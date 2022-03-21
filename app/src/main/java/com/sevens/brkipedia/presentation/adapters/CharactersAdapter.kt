package com.sevens.brkipedia.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sevens.brkipedia.R
import com.sevens.brkipedia.databinding.ItemCharacterBinding
import com.sevens.brkipedia.domain.models.DomainCharacter

class CharactersAdapter(
    private val listener: ((DomainCharacter) -> Unit)?
) : ListAdapter<DomainCharacter, CharactersAdapter.CharacterViewHolder>(DiffCharacterCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener { listener?.invoke(character) }
    }

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemCharacterBinding.bind(itemView)
        fun bind(character: DomainCharacter) = with(binding){
            Glide.with(itemView).load(character.img).centerCrop().into(characterImage)
            nicknameText.text = character.nickname
        }

        companion object{
            fun create(parent: ViewGroup): CharacterViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_character, parent, false)
                return CharacterViewHolder(view)
            }
        }
    }

}

class DiffCharacterCallback: DiffUtil.ItemCallback<DomainCharacter>() {
    override fun areItemsTheSame(oldItem: DomainCharacter, newItem: DomainCharacter): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DomainCharacter, newItem: DomainCharacter): Boolean {
        return oldItem.img == newItem.img &&
                oldItem.nickname == newItem.nickname &&
                oldItem.actor == newItem.actor &&
                oldItem.name == newItem.name &&
                oldItem.birthday == newItem.birthday &&
                oldItem.seasons == newItem.seasons
    }

}
