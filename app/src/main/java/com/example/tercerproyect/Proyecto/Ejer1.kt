package com.example.tercerproyect.Proyecto

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejer1(){
    var color  by remember { mutableStateOf(Color.White) }
    val img1 = "https://images.unsplash.com/photo-1690743300330-d190ad8f97dc?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    val img2  = "https://images.unsplash.com/photo-1705077917740-dacd6ed4e0d7?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aWNvbm8lMjBjYW1iaW8lMjBhJTIwdGVtYSUyMG5vY2hlfGVufDB8fDB8fHwy"
    val img3 = "https://images.unsplash.com/photo-1626736357861-92d781800060?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    val estadoSnack =  remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Configuracion") })
        } ,
        snackbarHost = { SnackbarHost(hostState = estadoSnack) },
        bottomBar = {
            CrearBottonBar { texto ->
                scope.launch {
                    estadoSnack.showSnackbar("venta actual $texto ")
                }
            }
        }
    ){
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = color)
        ){
            CrearCard("Claro", "Tono claro , recordando al dia " , img1 ,{
                color = Color.White
                scope.launch{
                    estadoSnack.showSnackbar("El color ha cambiado a claro")
                }
            })
            CrearCard("Oscuro", "Tono oscuro , mas negro que el ollin " , img2 ,{
                color = Color.Black
                scope.launch{
                    estadoSnack.showSnackbar("El color ha cambiado a oscuro")
                }
            })
            CrearCard("Intermedo", "Tono  ni oscuro ni claro " , img3 ,{
                color = Color.DarkGray
                scope.launch{
                    estadoSnack.showSnackbar("El color ha cambiado a intermedio")
                }
            })
        }
    }
}


//funcion para crear los card
@Composable
fun CrearCard(titulo : String , descripcion : String  , url : String , clikable:() -> Unit ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable(){
                clikable()
            },
        elevation = CardDefaults. cardElevation ( defaultElevation = 50.dp),
        shape = RoundedCornerShape( size = 40.dp),
        colors = CardDefaults. cardColors(
            containerColor = Color.Green,
            contentColor = Color.Black
        ),
        border = BorderStroke(3.dp , Color.Red)
    ){
        Column(modifier = Modifier.padding(4.dp)) {
            Row {
                Text(text = titulo , fontSize = 24.sp , modifier = Modifier.padding(4.dp))
                AsyncImage(
                    model = url,
                    contentDescription = "Mi imagen",
                    modifier = Modifier.size(80.dp),
                    onError = { state ->
                        Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                    }
                )

            }
            Text(text = descripcion, modifier = Modifier.padding(4.dp))

        }
    }
}


//funcion para crear el botonBar
@Composable
fun CrearBottonBar(texto:(String) -> Unit){
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
                index = 1
                texto("Configuracion")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Configuracion"
                )
            },
            label = { Text("Configuracion") }
        )
        NavigationBarItem(
            selected = index == 3,
            onClick = {
                index = 1
                texto("Perfil")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") }
        )
    }
}
