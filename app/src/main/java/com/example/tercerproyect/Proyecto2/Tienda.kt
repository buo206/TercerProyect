package com.example.tercerproyect.Proyecto2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tienda(modifier: Modifier = Modifier){
    val estadoSnack =  remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var tienda by remember { mutableStateOf(true) }
    var carrito by remember { mutableStateOf(false) }
    var listaCompras = mutableListOf("")
    Scaffold(
        topBar = {
            TopAppBar(title = {Text("AguadoVents")})
        },
        snackbarHost = { SnackbarHost(hostState = estadoSnack) } ,
        bottomBar = {
            CrearBottonBar4(texto = { texto ->
                scope.launch {
                    estadoSnack.showSnackbar("venta actual $texto ")
                }
            } ,
                onClick1 = {
                    tienda = true
                    carrito = false
                } ,
                onClick2 = {
                    carrito = true
                    tienda = false
                })
        }
    ){
        innerPadding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
        ){
            if(tienda){
                LazyColumn(modifier = modifier.fillMaxWidth()){

                    items(getProducts()){
                            prodcuto ->
                        fabricarProducto(prodcuto){
                            scope.launch {
                                estadoSnack.showSnackbar("Añadido al carrito el producto de ${prodcuto.marca} ")
                            }
                            if(!listaCompras.contains(prodcuto.marca + " " + prodcuto.descripcion)){
                                listaCompras.add(prodcuto.marca + " " + prodcuto.descripcion)
                            }
                        }
                    }
                }
            }else{
                Text("Compras Realizadas")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                   items(listaCompras){
                       nombre-> Text(nombre)
                   }
                }
            }

        }
    }
}

@Composable
fun CrearBottonBar4(texto:(String) -> Unit , onClick1:() -> Unit , onClick2:() -> Unit ){
    var index by remember { mutableStateOf(1) }
    NavigationBar{
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
                texto("Tienda")
                onClick1()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Tienda"
                )
            },
            label = { Text("Tienda") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                texto("Carrtio")
                onClick2()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "NotificacCarrtioiones"
                )
            },
            label = { Text("Carrtio") }
        )

    }
}