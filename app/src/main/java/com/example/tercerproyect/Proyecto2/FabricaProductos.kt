package com.example.tercerproyect.Proyecto2

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

import com.example.tercerproyect.R

@Composable
fun fabricarProducto(producto: Producto, onItemSelected: (Producto) -> Unit){
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onItemSelected(producto) }
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = producto.image,
                contentDescription = "Mi imagen",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(180.dp),
                onError = { state ->
                    Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                }
            )
            Text(
                text = producto.marca, fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = producto.descripcion , fontSize = 20.sp ,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}



fun getProducts(): List<Producto> {
    return listOf(
        Producto("Kechua", "Cascos protectores de escalada", R.drawable.escalada),
        Producto("Gisela", "Estampado sobre camiseta  de gato ", R.drawable.cat),
        Producto("Fender", "Guitarra  fender afinada", R.drawable.guitar),
        Producto("JOMAFA", "Pack de herramientas basicas ", R.drawable.herrramienta),
        Producto("Play Station", "Mando estandar pra ps4 dualshock4", R.drawable.mando),
        Producto("Ceramic", "Pack de tazas de ceramica elegantes ", R.drawable.tazas)
    )

}