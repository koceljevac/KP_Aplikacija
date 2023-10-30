package com.example.kupujemprodajemaplikacija.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kupujemprodajemaplikacija.ui.ad.AdRepository

class DetailsAdViewModelFactory (private val repository: AdRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsAdViewModel::class.java)) {
            return DetailsAdViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}