package com.example.my_transfer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_transfer.databinding.ItemRvBinding
import com.example.my_transfer.db.MyCard

class MyCardAdapter(val list: List<MyCard>): RecyclerView.Adapter<MyCardAdapter.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){

    fun onBind(myCard: MyCard, position: Int){

        itemRvBinding.tvName.text = myCard.name
        itemRvBinding.tvNumber.text = myCard.cardNumber.toString()

    }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}