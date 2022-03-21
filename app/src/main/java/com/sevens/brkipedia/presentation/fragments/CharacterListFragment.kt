package com.sevens.brkipedia.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sevens.brkipedia.databinding.FragmentCharacterListBinding
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.presentation.adapters.CharactersAdapter
import com.sevens.brkipedia.presentation.viewmodels.CharacterListViewModel

private const val CATEGORY = "category"

class CharacterListFragment : Fragment() {

    private lateinit var _binding: FragmentCharacterListBinding
    private val binding: FragmentCharacterListBinding get() { return _binding }

    private val characterListViewModel: CharacterListViewModel by viewModels()

    private lateinit var category: Category


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            bundle.getString(CATEGORY)?.let{
                category = Category.valueOf(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        characterListViewModel.category.postValue(category)
        _binding = FragmentCharacterListBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val charactersAdapter = CharactersAdapter {
            character ->
            findNavController().navigate(
                CategoriesFragmentDirections
                    .actionCategoriesFragmentToCharacterFragment(character)
            )
        }

        binding.charactersList.adapter = charactersAdapter
        characterListViewModel.charactersByCategory.observe(viewLifecycleOwner) { characters ->
            charactersAdapter.submitList(characters)
        }

        characterListViewModel.getCharactersByCategory(category)
    }

    companion object {
        @JvmStatic
        fun newInstance(category: Category) =
            CharacterListFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY, category.value)
                }
            }
    }

}