package com.example.avito_mobile_dombrovskiy.TestRetrofit.Quote

import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}