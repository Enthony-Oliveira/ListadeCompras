package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton = findViewById<Button>(R.id.btn_adicionar)
        addButton.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }
    }
}