package com.example.rickymartin.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.example.rickymartin.ui.viewmodel.ListViewModel


@Composable
fun CharacterList(viewModel: ListViewModel) {
    val characters = viewModel.characters.collectAsState()
    LazyColumn {
        items(characters.size){
                character ->
             Text(text = characters.value[character].name.toString())
        }
    }
    DisposableEffect(Unit) {
        viewModel.getCharacters()
        onDispose {}
    }
}


