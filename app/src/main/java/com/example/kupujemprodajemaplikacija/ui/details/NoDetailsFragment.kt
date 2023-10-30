package com.example.kupujemprodajemaplikacija.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kupujemprodajemaplikacija.R
import com.example.kupujemprodajemaplikacija.databinding.FragmentHomeBinding
import com.example.kupujemprodajemaplikacija.databinding.FragmentNoDetailsBinding


class NoDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNoDetailsBinding.inflate(inflater, container, false)
        binding.fragment = this
        return binding.root
    }

    fun back() {
        activity?.onBackPressed()
    }

}