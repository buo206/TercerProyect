package com.example.tercerproyect.Proyecto

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
fun Ejer2(){
    val estadoSnack =  remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var avatares =  rememberSaveable { mutableListOf("https://plus.unsplash.com/premium_vector-1719858611039-66c134efa74d?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        , "https://plus.unsplash.com/premium_vector-1682269284255-8209b981c625?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        , "https://plus.unsplash.com/premium_vector-1727955579176-073f1c85dcda?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D") }
    var url by remember { mutableStateOf(avatares[0]) }
    var avatar by rememberSaveable { mutableStateOf(true) }
    var notificaciones by rememberSaveable { mutableStateOf(false) }
    var ajustes by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mi perfil") })
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
            CrearBottonBar2 (
                texto = { texto ->
                    scope.launch {
                        estadoSnack.showSnackbar("venta actual $texto ")
                    }
                } ,
                onClick1 = {
                    avatar = true
                    notificaciones = false
                    ajustes = false
                } ,
                onClick2 = {
                    avatar = false
                    notificaciones = true
                    ajustes = false
                },
                onClick3 = {
                    avatar = false
                    notificaciones = false
                    ajustes = true
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
            if(avatar){
                AsyncImage(
                    model = url,
                    contentDescription = "Mi imagen",
                    modifier = Modifier.size(200.dp).padding(10.dp),
                    onError = { state ->
                        Log.e("COIL", "Error al cargar imagen", state.result.throwable)
                    }
                )
                Text(text = "Nombre :  buo" , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
                Text(text = "Correo :  buo@gmail.com" , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
                Row(modifier = Modifier.padding(8.dp)){
                    Button( modifier = Modifier.padding(2.dp), onClick = {
                        url = avatares[0]
                        scope.launch{
                            estadoSnack.showSnackbar("Avatar Actualizado")
                        }
                    }) {
                        Text("Avatar 1")
                    }

                    Button(modifier = Modifier.padding(2.dp), onClick = {
                        url = avatares[1]
                        scope.launch{
                            estadoSnack.showSnackbar("Avatar Actualizado")
                        }
                    }) {
                        Text("Avatar 2")
                    }

                    Button(modifier = Modifier.padding(2.dp), onClick = {
                        url = avatares[2]
                        scope.launch{
                            estadoSnack.showSnackbar("Avatar Actualizado")
                        }
                    }) {
                        Text("Avatar 3")
                    }
                }
            }else if(notificaciones){
                Text(text = "No hay notificaciones " , fontSize = 18.sp , modifier = Modifier.padding(4.dp))
            }else if(ajustes){
                var emails by rememberSaveable { mutableStateOf(false) }
                var textE by rememberSaveable { mutableStateOf("no") }
                var silenciar by rememberSaveable { mutableStateOf(true) }
                var textS by rememberSaveable { mutableStateOf("si") }
                Row(){
                    Button(
                        onClick = {
                            emails = !emails
                        } ,
                        modifier = Modifier.padding(4.dp)
                    ) { Text("Recibir emails")}
                    if(emails){textE = "si"}else{textE="no"}
                    Text(textE)
                }
                Row(){
                    Button(
                        onClick = {
                            silenciar = !silenciar
                        } ,
                        modifier = Modifier.padding(4.dp)
                    ) { Text("Recibir emails")}
                    if(silenciar){textS = "si"}else{textS="no"}
                    Text(textS)
                }
            }
        }


    }
}



@Composable
fun CrearBottonBar2(texto:(String) -> Unit , onClick1:() -> Unit , onClick2:() -> Unit , onClick3:() -> Unit){
    var index by remember { mutableStateOf(1) }
    NavigationBar{
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
                texto("Perfil")
                onClick1()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                texto("Notificaciones")
                onClick2()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Notificaciones"
                )
            },
            label = { Text("Notificaciones") }
        )
        NavigationBarItem(
            selected = index == 3,
            onClick = {
                index = 3
                texto("Ajustes")
                onClick3()
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Ajustes"
                )
            },
            label = { Text("Ajustes") }
        )
    }
}