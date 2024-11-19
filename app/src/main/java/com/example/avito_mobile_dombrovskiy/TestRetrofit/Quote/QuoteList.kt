package com.example.avito_mobile_dombrovskiy.TestRetrofit.Quote

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)
