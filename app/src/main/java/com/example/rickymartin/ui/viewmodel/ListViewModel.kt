package com.example.rickymartin.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickymartin.data.ResultsItem
import com.example.rickymartin.network.RetrofitInstance

import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val characters: MutableState<List<ResultsItem>> = mutableStateOf(emptyList())
    fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = apiService.getACharacters()
                characters.value = response.results as List<ResultsItem>
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

