package com.example.homework42.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework42.ui.fragments.anime.AnimeFragment
import com.example.homework42.ui.fragments.manga.MangaFragment

class PagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AnimeFragment()
            else -> MangaFragment()
        }
    }
}