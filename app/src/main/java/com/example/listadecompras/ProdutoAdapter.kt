package com.example.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ProdutoAdapter(contexto : Context) : ArrayAdapter<Produto>(contexto,0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val txt_produto = v.findViewById<TextView>(R.id.txt_item_produto)
        val txt_quantidade = v.findViewById<TextView>(R.id.txt_qtd)
        val txt_valor = v.findViewById<TextView>(R.id.txt_valor)
        val img_produto = v.findViewById<ImageView>(R.id.img)

        val item = getItem(position)

        txt_produto.text = item?.nome
        txt_quantidade.text = item?.quanitdade.toString()
        txt_valor.text = item?.valor.toString()

        if (item?.foto != null){
            img_produto.setImageBitmap(item.foto)
        }

        return  v

        // return super.getView(position, convertView, parent)
    }
}