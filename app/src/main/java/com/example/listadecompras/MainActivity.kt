package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botaoInserir =findViewById<Button>(R.id.btn_adicionar)
        botaoInserir.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        val adaptador = ProdutoAdapter(this)
        adaptador.addAll(produtosglobal)

        val list_view_produtos = findViewById<ListView>(R.id.list_produtos)
        list_view_produtos.adapter = adaptador
    }
}