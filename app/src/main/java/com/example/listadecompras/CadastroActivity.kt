package com.example.listadecompras

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CadastroActivity : AppCompatActivity() {
    private var fotoCapturada: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.NomeProduto)
        val txt_quantidade = findViewById<EditText>(R.id.Qtd_itens)
        val txt_valor = findViewById<EditText>(R.id.txt_valor)
        val img_produto = findViewById<ImageView>(R.id.Camera_produto)

        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val imagemBitmap = data?.extras?.get("data") as? Bitmap

                if (imagemBitmap != null) {
                    fotoCapturada = imagemBitmap
                    img_produto.setImageBitmap(fotoCapturada)
                }
            }
        }

        img_produto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
            } else {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                activityResultLauncher.launch(intent)
            }
        }

        btn_inserir.setOnClickListener {
            val nome = txt_produto.text.toString()
            val qtdTexto = txt_quantidade.text.toString()
            val precoTexto = txt_valor.text.toString()

            if (nome.isNotEmpty() && qtdTexto.isNotEmpty() && precoTexto.isNotEmpty()) {
                try {
                    val qtd = qtdTexto.toInt()
                    val preco = precoTexto.replace(",", ".").toDouble()

                    val produto = Produto(nome, qtd, preco, fotoCapturada)

                    produtosglobal.add(produto)

                    Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                    txt_produto.text.clear()
                    txt_quantidade.text.clear()
                    txt_valor.text.clear()

                    img_produto.setImageResource(android.R.drawable.ic_menu_camera)
                    fotoCapturada = null

                    txt_produto.requestFocus()

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Erro: Verifique os números digitados", Toast.LENGTH_SHORT).show()
                }
            } else {
                txt_produto.error = "Preencha todos os campos"
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}