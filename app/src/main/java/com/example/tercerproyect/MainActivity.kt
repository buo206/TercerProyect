package com.example.tercerproyect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tercerproyect.Lazy.SimpleLazyColumn
import com.example.tercerproyect.Proyecto.Ejer1
import com.example.tercerproyect.Proyecto.Ejer2
import com.example.tercerproyect.Proyecto.Ejer3
import com.example.tercerproyect.Proyecto2.Tienda
import com.example.tercerproyect.ui.theme.TercerProyectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TercerProyectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column{
        //Ejer1()
        //Ejer2()
        //Ejer3()
        //SimpleLazyColumn(modifier)
        Tienda(modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TercerProyectTheme {
        Greeting("Android")
    }
}