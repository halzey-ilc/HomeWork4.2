package com.example.homework42.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework42.R
import com.example.homework42.base.BaseFragment
import com.example.homework42.databinding.FragmentMangaDetailBinding
import com.example.homework42.utils.Resource
import com.example.homework42.utils.showText
import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class MangaDetailFragment : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(
        R.layout.fragment_manga_detail
    ) {
        override val viewModel: MangaDetailViewModel by viewModels()
        override val binding by viewBinding(FragmentMangaDetailBinding::bind)
        private val args by navArgs<MangaDetailFragmentArgs>()

        override fun setupSubscribes() {
            subscribeToAnimeById()
        }

        private fun subscribeToAnimeById() = with(binding) {
            viewModel.fetchMangaDetail(args.id).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Error -> {
                        showText("Error")
                    }
                    is Resource.Loading -> {
                        showText("Loading")
                    }
                    is Resource.Success -> {
                        Glide.with(ivFullscreenManga.context)
                            .load(it.data?.data?.attributes?.posterImage?.original)
                            .into(ivFullscreenManga)
                        tvNameDetail.text = it.data?.data?.attributes?.titles?.enJp
                    }
                }
            }
        }
    }