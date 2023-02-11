package com.example.homework42.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework42.R
import com.example.homework42.base.BaseFragment
import com.example.homework42.databinding.FragmentMangaBinding
import com.example.homework42.ui.adapters.MangaAdapter
import com.example.homework42.ui.fragments.home.HomeFragmentDirections
import com.example.homework42.utils.Resource
import com.example.homework42.utils.showText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClickListeners)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun setupRecycler() = with(binding) {
        recyclerview.adapter = mangaAdapter
    }

    private fun subscribeToAnimeById() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    mangaAdapter.submitList(it.data?.data)
                }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}