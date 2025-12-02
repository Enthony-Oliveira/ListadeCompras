package com.example.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botoa_cadastrar = findViewById<Button>(R.id.btn_inserir)
        botoa_cadastrar.setOnClickListener{
            val txt_produto = findViewById<EditText>(R.id.NomeProduto)
            val txt_quantidade = findViewById<EditText>(R.id.Qtd_itens)
            val txt_valor = findViewById<EditText>(R.id.txt_valor)

            val nome = txt_produto.text.toString()
            val qtd = txt_quantidade.text.toString().toInt()
            val preco = txt_valor.text.toString().toDouble()

            val produto = Produto(nome, qtd, preco)
            produtosglobal.add(produto)
        }

    }
}