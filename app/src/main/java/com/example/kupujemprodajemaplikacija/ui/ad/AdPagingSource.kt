package com.example.kupujemprodajemaplikacija.ui.ad

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kupujemprodajemaplikacija.models.Ad
import kotlinx.coroutines.delay

class AdPagingSource(private val adRepository: AdRepository) : PagingSource<Int, Ad>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Ad> {
        try {
            val nextPageNumber = params.key ?: 1

            val ads: List<Ad>
            val nextPage: Int?

            if (nextPageNumber <= 2) {
                ads = adRepository.getAds(nextPageNumber, params.loadSize)
                nextPage = if (ads.isEmpty()) null else nextPageNumber + 1
            } else {
                delay(500)
                ads = adRepository.getAds(nextPageNumber, params.loadSize)
                nextPage = if (ads.isEmpty()) null else nextPageNumber + 1
            }
            Log.d("AdPagingSource", "Loaded ${ads.size} ads for page: $nextPageNumber")
            return LoadResult.Page(
                data = ads,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Ad>): Int? {
        return state.anchorPosition
    }
}

