package com.example.listadecompras

import android.graphics.Bitmap

data class Produto (
    val nome: String,
    val quanitdade: Int,
    val valor: Double,
    val foto: Bitmap? = null
)