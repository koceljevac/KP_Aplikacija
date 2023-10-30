package com.example.kupujemprodajemaplikacija.ui.details

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kupujemprodajemaplikacija.models.Ad
import com.example.kupujemprodajemaplikacija.models.AdDetails
import com.example.kupujemprodajemaplikacija.ui.ad.AdPagingSource
import com.example.kupujemprodajemaplikacija.ui.ad.AdRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsAdViewModel(private val repository: AdRepository) : ViewModel() {

    private val _adDetails = MutableStateFlow<AdDetails?>(null)
    val adDetails: StateFlow<AdDetails?> get() = _adDetails

    private val _ad = MutableStateFlow<Ad?>(null)
    val ad: StateFlow<Ad?> get() = _ad

    val name = ObservableField("")
    val price = ObservableField("")
    val location = ObservableField("")

    private val _plainTextDescription = MutableStateFlow("")
    val plainTextDescription: StateFlow<String> get() = _plainTextDescription

    fun loadAdDetails(adId: Int) {
        viewModelScope.launch {
            val details = repository.getAdDetailsById(adId)
            _adDetails.value = details
        }
    }
    fun loadAd(adId: Int) {
        viewModelScope.launch {
            val adDet = repository.getAdsById(adId)
            adDet?.let {
                _ad.value = adDet
            }
        }
    }

    fun setPlainTextDescription(description: String) {
        _plainTextDescription.value = description
    }
}