package com.example.kupujemprodajemaplikacija.models

data class AdDetails(
    val ad_id: String,
    val location_name: String,
    val category_name: String,
    val group_name: String,
    val description: String,
    val photos: String
)
data class AdDetailsList(val detaljiOglasa: List<AdDetails>)