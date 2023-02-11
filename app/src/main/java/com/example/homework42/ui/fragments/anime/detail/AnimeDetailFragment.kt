package com.example.homework42.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework42.R
import com.example.homework42.base.BaseFragment
import com.example.homework42.databinding.FragmentAnimeDetailBinding
import com.example.homework42.utils.Resource
import com.example.homework42.utils.showText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(
    R.layout.fragment_anime_detail
) {
    override val viewModel: AnimeDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Detail")
                }
                is Resource.Success -> {
                    Glide.with(ivFullscreen.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(ivFullscreen)
                    tvNameDetail.text = it.data?.data?.attributes?.titles?.enJp
                }
            }
        }
    }
}
