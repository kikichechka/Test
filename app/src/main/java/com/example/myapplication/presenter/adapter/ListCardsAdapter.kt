package com.example.myapplication.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.CardDTO
import com.example.myapplication.databinding.ItemCardBinding

class ListCardsAdapter(private val list: List<CardDTO>) :
    RecyclerView.Adapter<ListCardsAdapter.ListCardsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCardsHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context))
        return ListCardsHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListCardsHolder, position: Int) {
        val card = list[position]
        holder.binding.idCard.text = card.id.toString()
        with(holder.binding.details) {
            setSchemeType(card.scheme)
            setNumber(card.number)
            setBrand(card.brand)
            setCardType(card.type)
            setPrepaid(card.prepaid)
            setCountry(card.country)
            setBankInformation(card.bank)
        }
    }

    class ListCardsHolder(
        val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root)
}
