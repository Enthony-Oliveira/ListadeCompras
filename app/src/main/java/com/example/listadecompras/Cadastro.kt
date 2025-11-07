package com.example.listadecompras

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        val adapter_produtos = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
//        val list_view = findViewById<ListView>(R.id.list_view_produtos)
//
//        list_view.adapter = adapter_produtos
//
//        val editText = findViewById<EditText>(R.id.NomeProduto)
//        val botao = findViewById<Button>(R.id.btn_inserir)
//
//        btn_inserir.setOnClickerListener{
//            val nome_produto = editText.text.toString()
//            adapter_produtos.add(nome_produto)
//        }
    }
}