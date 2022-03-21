package com.sevens.brkipedia.presentation.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sevens.brkipedia.R
import com.sevens.brkipedia.databinding.FragmentCharacterDetailBinding
import com.sevens.brkipedia.presentation.adapters.CharactersAdapter
import com.sevens.brkipedia.presentation.adapters.DetailQuotesAdapter
import com.sevens.brkipedia.presentation.adapters.DetailSeasonsAdapter
import com.sevens.brkipedia.presentation.viewmodels.CharacterDetailViewModel
import java.util.*

class CharacterDetailFragment : Fragment() {

    private lateinit var _binding: FragmentCharacterDetailBinding
    private val binding: FragmentCharacterDetailBinding get() { return _binding}

    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            Glide.with(requireContext()).load(args.character.img).centerCrop().into(imageView)
            nicknameText.text = args.character.nickname
            actorNameText.text = args.character.actor
            characterNameText.text = args.character.name
            ageText.text = getYears(args.character.birthday)
            seasonsText.text = getString(R.string.character_detail_season_title)
            val seasonsAdapter = DetailSeasonsAdapter {
                    season ->
                Toast.makeText(requireContext(), getString(R.string.character_detail_season_toast, season.toString()), Toast.LENGTH_SHORT).show()
            }
            seasonsList.adapter = seasonsAdapter
            seasonsAdapter.submitList(args.character.seasons)

            val quotesAdapter = DetailQuotesAdapter {
                    quote ->
                val clipboardManager = requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData = ClipData.newPlainText("text", quote.text)
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(requireContext(), getString(R.string.character_detail_famous_quotes_toast), Toast.LENGTH_LONG).show()
            }
            characterDetailViewModel.quotesByAuthor.observe(viewLifecycleOwner){
                quotesAdapter.submitList(it)
            }
            famousQuotesList.adapter = quotesAdapter
            famousQuotesText.text = getString(R.string.character_detail_famous_quotes_title)
            characterDetailViewModel.getQuotesByAuthor(args.character.name)
        }
    }

    private fun getYears(date: Date?): String {
        var age: Long = 0
        date?.let{
            val cal = Calendar.getInstance()
            age = (cal.time.time - date.time) / 86400000 / 365
        }
        return if(age > 0 ) age.toString() + " years" else "UNKNOWN"
    }
}