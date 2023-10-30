package com.example.kupujemprodajemaplikacija.utils

import com.example.kupujemprodajemaplikacija.models.Ad

object Utils {

    fun adToCurrency(ad: Ad): String {
        val currencies = mapOf("eur" to "€", "dollar" to "$", "rsd" to "din")
        val currencySymbol = if (ad.currency in currencies) {
            currencies[ad.currency]
        } else {
            null
        }
        return if (currencySymbol != null) {
            "${ad.price} $currencySymbol"
        } else {
            "Kontakt"
        }
    }


}