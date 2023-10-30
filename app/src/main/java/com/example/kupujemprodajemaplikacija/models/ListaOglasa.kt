package com.example.kupujemprodajemaplikacija.models

data class ListaOglasa(
    val ads: List<Ad>,
    val page: Int,
    val pages: Int
)