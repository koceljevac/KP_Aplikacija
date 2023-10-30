package com.example.kupujemprodajemaplikacija.ui.ad

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kupujemprodajemaplikacija.models.Ad
import com.example.kupujemprodajemaplikacija.models.AdDetails
import com.example.kupujemprodajemaplikacija.models.AdResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AdViewModel(private val repository: AdRepository) : ViewModel() {
    fun getAds(): Flow<PagingData<Ad>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 10,),
            pagingSourceFactory = { AdPagingSource(repository) }
        ).flow
    }
}
