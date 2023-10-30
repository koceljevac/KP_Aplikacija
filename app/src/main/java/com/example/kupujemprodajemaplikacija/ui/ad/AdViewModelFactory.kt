package com.example.kupujemprodajemaplikacija.ui.ad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AdViewModelFactory(private val repository: AdRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdViewModel::class.java)) {
            return AdViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

