package com.example.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.NumberFormat
import java.util.Locale

fun salvarLista(context: Context) {
    val sharedPreferences = context.getSharedPreferences("ListaComprasApp", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    val gson = Gson()
    val json = gson.toJson(produtosglobal)
    editor.putString("lista_produtos", json)
    editor.apply()
}

fun carregarLista(context: Context) {
    val sharedPreferences = context.getSharedPreferences("ListaComprasApp", Context.MODE_PRIVATE)
    val gson = Gson()
    val json = sharedPreferences.getString("lista_produtos", null)

    if (json != null) {
        val tipoLista = object : TypeToken<ArrayList<Produto>>() {}.type
        val listaSalva: ArrayList<Produto> = gson.fromJson(json, tipoLista)

        produtosglobal.clear()
        produtosglobal.addAll(listaSalva)
    }
}

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    var onItemRemoved: (() -> Unit)? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_view_item, parent, false)

        val item = getItem(position)

        val txt_produto = v.findViewById<TextView>(R.id.txt_item_produto)
        val txt_quantidade = v.findViewById<TextView>(R.id.txt_qtd)
        val txt_valor = v.findViewById<TextView>(R.id.txt_valor)
        val img_produto = v.findViewById<ImageView>(R.id.img)
        val btn_deletar = v.findViewById<ImageView>(R.id.btn_deletar)

        if (item != null) {
            txt_produto.text = item.nome
            txt_quantidade.text = "Qtd: ${item.quanitdade}"

            val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            txt_valor.text = formatador.format(item.valor)

            if (item.foto != null) {
                img_produto.setImageBitmap(item.foto)
            } else {
                img_produto.setImageResource(android.R.drawable.ic_menu_gallery)
            }

            btn_deletar.setOnClickListener {

                this.remove(item)
                produtosglobal.remove(item)

                salvarLista(context)
                notifyDataSetChanged()

                Toast.makeText(context, "Produto excluído", Toast.LENGTH_SHORT).show()

                onItemRemoved?.invoke()
            }
        }
        return v
    }
}
