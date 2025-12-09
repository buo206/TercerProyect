package com.example.tercerproyect.Proyecto

import android.R.attr.navigationIcon
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejer3(){
    val estadoSnack =  remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var avatares =  rememberSaveable { mutableListOf("https://images.unsplash.com/photo-1618366712010-f4ae9c647dcb?q=80&w=688&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        , "https://images.unsplash.com/photo-1555421689-3f034debb7a6?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    , "https://images.unsplash.com/photo-1599855129460-58c62b60e3df?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ) }
    var url by remember { mutableStateOf(avatares[0]) }
    var caracteres by rememberSaveable { mutableStateOf("Inicio") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Auriculares Pro X") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch{
                            estadoSnack.showSnackbar("Volver no establecido ")
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Menú"
                        )
                    }
                }
            )
        } ,
        snackbarHost = {
            SnackbarHost(
                hostState = estadoSnack,
                snackbar = { data ->
                    Snackbar(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Text(
                                text = data.visuals.message,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth().padding(4.dp)
                            )
                        }
                    )
                }
            )
        } ,
        bottomBar = {
            CrearBottonBar3 (
                texto = { texto ->
                    caracteres = texto
                }
            )
        }


    ){innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                AsyncImage(
                    model = url,
                    contentDescription = "Mi imagen",
                    modifier = Modifier.size(200.dp).padding(10.dp),
                    onError = { state ->
                        Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                    }
                )


                Row(modifier = Modifier.padding(8.dp)){
                    AsyncImage(
                        model = avatares[0],
                        contentDescription = "Mi imagen",
                        modifier = Modifier.size(130.dp).padding(10.dp).clickable{
                            url = avatares[0]
                        },
                        onError = { state ->
                            Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                        }
                    )
                    AsyncImage(
                        model = avatares[1],
                        contentDescription = "Mi imagen",
                        modifier = Modifier.size(130.dp).padding(10.dp).clickable{
                            url = avatares[1]
                        },
                        onError = { state ->
                            Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                        }
                    )
                    AsyncImage(
                        model = avatares[2],
                        contentDescription = "Mi imagen",
                        modifier = Modifier.size(130.dp).padding(10.dp).clickable{
                            url = avatares[2]
                        },
                        onError = { state ->
                            Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                        }
                    )


                }

                Text(text = "ARRICULAS PRO X  " , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
                Text(text = "PRECIO :  300€ " , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
                Text(text = "Arriculares de soni de ultima genereacion con 18 horas de bateria de una solo carga " , fontSize = 18.sp , modifier = Modifier.padding(4.dp))

                Button(modifier = Modifier.padding(2.dp), onClick = {
                    scope.launch{
                        estadoSnack.showSnackbar("Articulo añadido al carrito")
                    }
                }){
                    Text("Añadir al carrito")
                }
                Button(modifier = Modifier.padding(2.dp), onClick = {
                    scope.launch{
                        estadoSnack.showSnackbar("Compra rapida no disponible")
                    }
                }){
                    Text("Comprar ahora ")
                }

                Text(text = caracteres , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
            }
    }
}


@Composable
fun CrearBottonBar3(texto:(String) -> Unit ){
    var index by remember { mutableStateOf(1) }
    NavigationBar{
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
                texto("Inicio")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Inicio"
                )
            },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                texto("Catalogo")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Catalogo"
                )
            },
            label = { Text("Catalogo") }
        )
        NavigationBarItem(
            selected = index == 3,
            onClick = {
                index = 3
                texto("Carrito")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Carrito"
                )
            },
            label = { Text("Carrito") }
        )
    }
}