package com.example.kupujemprodajemaplikacija.ui.ad

import android.content.Context
import com.example.kupujemprodajemaplikacija.models.Ad
import com.example.kupujemprodajemaplikacija.models.AdDetails
import com.example.kupujemprodajemaplikacija.models.AdDetailsList
import com.example.kupujemprodajemaplikacija.models.AdList
import com.example.kupujemprodajemaplikacija.models.AdResponse
import com.google.gson.Gson


class AdRepository(private val context: Context) {
    private val gson =Gson()
    suspend fun getAds(pageNumber: Int, pageSize: Int): List<Ad> {
        val json = context.assets.open("oglasi.json").bufferedReader().use { it.readText() }
        val oglasResponse = gson.fromJson(json, AdResponse::class.java)
        val allAds = oglasResponse.listaOglasa.flatMap { it.ads }
        val startIndex = (pageNumber - 1) * pageSize
        val endIndex = minOf(startIndex + pageSize, allAds.size)
        return allAds.subList(startIndex, endIndex)
    }

    suspend fun getAdDetailsById(adId: Int): AdDetails? {
        val json = context.assets.open("oglasi.json").bufferedReader().use { it.readText() }
        val adDetailsList = gson.fromJson(json, AdDetailsList::class.java)?.detaljiOglasa
        return adDetailsList?.find { it.ad_id == adId.toString() }
    }

    suspend fun getAdsById(adId: Int): Ad? {
        val json = context.assets.open("oglasi.json").bufferedReader().use { it.readText() }
        val adsById = gson.fromJson(json, AdList::class.java)?.ads
        return adsById?.find { it.ad_id==adId }
    }
}
