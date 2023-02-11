package com.example.homework42.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework42.R
import com.example.homework42.base.BaseFragment
import com.example.homework42.databinding.FragmentAnimeBinding
import com.example.homework42.ui.adapters.AnimeAdapter
import com.example.homework42.ui.fragments.home.HomeFragmentDirections
import com.example.homework42.utils.Resource
import com.example.homework42.utils.showText
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(
    R.layout.fragment_anime
) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClickListeners)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun setupRecycler() = with(binding) {
        recyclerviewRating.adapter = animeAdapter
    }

    private fun subscribeToAnimeById() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.data)
                }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(
                id.toInt()
            )
        )
    }
}