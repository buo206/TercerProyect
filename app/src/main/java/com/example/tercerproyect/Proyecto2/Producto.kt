package com.example.tercerproyect.Proyecto2

import androidx.annotation.DrawableRes

data class Producto (
    var marca:String ,
    var descripcion:String ,
    @DrawableRes var image: Int
)