package com.example.islami.fragments.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.appConstants
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.databinding.QuranItemsBinding

class Quranfragment:Fragment() {
    lateinit var adapter: ChapterAdapter
    lateinit var viewBinding:FragmentQuranBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding=FragmentQuranBinding.inflate(layoutInflater,container,false)

        return viewBinding.root

    }

    val chapters=appConstants.getchapters()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       adapter=ChapterAdapter(chapters)
        viewBinding.chapterRecycler.adapter=adapter


    }
}


