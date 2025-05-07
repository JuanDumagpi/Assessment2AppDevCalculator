package com.example.metric2murica_temp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.metric2murica_temp.databinding.FragmentTutorialPopUpBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class tutorialPopUp : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentTutorialPopUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTutorialPopUpBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}