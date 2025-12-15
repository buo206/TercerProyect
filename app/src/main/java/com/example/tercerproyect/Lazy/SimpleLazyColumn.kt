package com.example.tercerproyect.Lazy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLazyColumn(modifier: Modifier){
    Column(modifier = modifier .fillMaxSize()){
        Text("Reafae")
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            item { Text("A") }
            item { Text("B") }
            item { Text("C") }
            items(100000){
                    index -> Text("Elemento $index")
            }
        }

        Text("Final")
    }

}