package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botaoInserir = findViewById<Button>(R.id.btn_adicionar)
        botaoInserir.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        val adaptador = ProdutoAdapter(this)
        adaptador.addAll(produtosglobal)

        val list_view_produtos = findViewById<ListView>(R.id.list_produtos)
        list_view_produtos.adapter = adaptador

        // 🔥 QUANDO APAGAR UM ITEM, ATUALIZA O TOTAL
        adaptador.onItemRemoved = {
            atualizarTotal()
        }

        // Calcula o total inicial
        atualizarTotal()
    }

    // 🔥 FUNÇÃO QUE ATUALIZA O TOTAL NA TELA
    private fun atualizarTotal() {
        var total = 0.0

        for (produto in produtosglobal) {
            total += produto.quanitdade * produto.valor
        }

        val txt_total = findViewById<TextView>(R.id.txt_total)
        val f = NumberFormat.getNumberInstance(Locale("pt", "br"))
        txt_total.text = "TOTAL R$: ${f.format(total)}"
    }
}
