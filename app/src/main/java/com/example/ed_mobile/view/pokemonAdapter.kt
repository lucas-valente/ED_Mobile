package com.example.ed_mobile.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ed_mobile.domain.Pokemon

import com.example.ed_mobile.R

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) {

            val atividade = itemView

            val ivPokemon = atividade.findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = atividade.findViewById<TextView>(R.id.tvNumber)
            val tvName = atividade.findViewById<TextView>(R.id.tvName)
            val tvType1 = atividade.findViewById<TextView>(R.id.tvType1)
            val tvType2 = atividade.findViewById<TextView>(R.id.tvType2)

            //TODO: load image with Glide

            tvNumber.text = "N ${item.formatteNumber}"
            tvName.text = item.name
            tvType1.text = item.types[0].nome

            if (item.types.size > 1) {
                tvType2.visibility = View.VISIBLE
                tvType2.text = item.types[1].nome
            } else {
                tvType2.visibility = View.GONE
            }

        }

    }


}