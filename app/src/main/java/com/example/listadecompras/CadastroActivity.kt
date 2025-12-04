package com.example.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        // Ajuste de insets (Edge-to-edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botao_cadastrar = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.NomeProduto)
        val txt_quantidade = findViewById<EditText>(R.id.Qtd_itens)
        val txt_valor = findViewById<EditText>(R.id.txt_valor)

        botao_cadastrar.setOnClickListener {
            val nome = txt_produto.text.toString()
            val qtdTexto = txt_quantidade.text.toString()
            val precoTexto = txt_valor.text.toString()

            // 1. Validação: Verifica se os campos não estão vazios antes de converter
            if (nome.isNotEmpty() && qtdTexto.isNotEmpty() && precoTexto.isNotEmpty()) {

                val qtd = qtdTexto.toInt()
                val preco = precoTexto.toDouble()

                val produto = Produto(nome, qtd, preco)

                // 2. Adiciona à lista global (Verifique a explicação abaixo sobre onde criar essa lista)
                produtosglobal.add(produto)

                Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                // Opcional: Limpar campos ou fechar a tela para voltar à lista
                // finish()
                txt_produto.text.clear().toString()
                txt_quantidade.text.clear().toString().toInt()
                txt_valor.text.clear().toString().toDouble()

            } else {
                txt_produto.error = "Preencha todos os campos"
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}