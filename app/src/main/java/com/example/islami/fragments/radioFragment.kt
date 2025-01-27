package com.example.islami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.databinding.FragmentRadioBinding

class radioFragment:Fragment() {
    lateinit var viewBinding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentRadioBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}