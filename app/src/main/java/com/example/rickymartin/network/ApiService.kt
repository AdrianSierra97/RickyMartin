package com.example.rickymartin.network

import com.example.rickymartin.data.Characters
import retrofit2.http.GET

interface ApiService {
    @GET("character/?page=1")
    suspend fun getACharacters() : Characters
}