package com.sevens.brkipedia.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.sevens.brkipedia.databinding.FragmentCategoriesBinding
import com.sevens.brkipedia.domain.common.Category

class CategoriesFragment: Fragment() {

    private lateinit var _binding: FragmentCategoriesBinding
    private val binding: FragmentCategoriesBinding get() { return _binding}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =FragmentAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getItemTitle(position)
        }.attach()

    }

    private fun getItemTitle(position: Int): String{
        return when(position){
            0 -> "Breaking Bad"
            1 -> "Better Call Saul"
            else -> "Breaking Bad"
        }
    }

    class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle){

        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> CharacterListFragment.newInstance(Category.BREAKING_BAD)
                1 -> CharacterListFragment.newInstance(Category.BETTER_CALL_SAUL)
                else -> CharacterListFragment.newInstance(Category.BREAKING_BAD)
            }
        }
    }
}