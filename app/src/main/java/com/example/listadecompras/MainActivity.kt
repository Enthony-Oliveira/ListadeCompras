package com.example.listadecompras

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val adapter_produtos = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        val nomeProdutoEditText = findViewById<EditText>(R.id.NomeProduto)
        val qtdItensEditText = findViewById<EditText>(R.id.Qtd_itens)
        val valorEditText = findViewById<EditText>(R.id.txt_valor)
        val botaoInserir = findViewById<Button>(R.id.btn_inserir)

        botaoInserir.setOnClickListener{
            val nome = nomeProdutoEditText.text.toString().trim()
            val quantidade = qtdItensEditText.text.toString().trim()
            val valor = valorEditText.text.toString().trim()

            if (nome.isNotBlank()) {
                val produtoFormatado = "Produto: $nome | Qtd: $quantidade | R$: $valor"

                adapter_produtos.add(produtoFormatado)
                adapter_produtos.notifyDataSetChanged()

                nomeProdutoEditText.text.clear()
                qtdItensEditText.text.clear()
                valorEditText.text.clear()
                nomeProdutoEditText.requestFocus()
            } else {
                Toast.makeText(this, "O Nome do Produto é obrigatório!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}