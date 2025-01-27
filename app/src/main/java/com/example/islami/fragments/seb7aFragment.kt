package com.example.islami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.databinding.FragmentSeb7aBinding

class seb7aFragment :Fragment() {
    lateinit var viewBinding: FragmentSeb7aBinding
    lateinit var azkarlist:MutableList<String>
    private var currentindex=0
    private var counter=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentSeb7aBinding.inflate(inflater,container,false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarlist=resources.getStringArray(R.array.Azkarlist).toMutableList()
        initView()
        onseb7aclick()

    }



    private fun initView() {
        viewBinding.tazkir.text=azkarlist[currentindex]
        viewBinding.seb7aCounter.text="$counter"

    }
    private fun onseb7aclick() {
        viewBinding.seb7aBody.setOnClickListener{
            viewBinding.seb7aBody.animate()
                .rotationBy((360 / 33)
                .toFloat())
                .setDuration(100)
                .start()
            if(counter<33){
                counter++
            }
            else{
                counter=0
                currentindex=if(currentindex<azkarlist.size-1) ++currentindex else 0
                viewBinding.tazkir.text=azkarlist[currentindex]
            }
            viewBinding.seb7aCounter.text= counter.toString()

        }

    }

}