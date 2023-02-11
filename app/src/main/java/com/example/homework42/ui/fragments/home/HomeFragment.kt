package com.example.homework42.ui.fragments.home
import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework42.R
import com.example.homework42.base.BaseFragment
import com.example.homework42.base.BaseViewModel
import com.example.homework42.databinding.FragmentHomeBinding
import com.example.homework42.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<BaseViewModel>()

    override fun initialize() {
        tabLayout()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun tabLayout() {
        binding.viewPager2.adapter = PagerAdapter(this)
                TabLayoutMediator(binding.tableLayout, binding.viewPager2) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Anime"
                }
                1 -> {
                    tab.text = "Manga"
                }
            }
        }
    }
}