package com.example.my_transfer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_transfer.databinding.ItemTransferRvBinding
import com.example.my_transfer.db.MyTransfer

class MyTransferAdapter(val list: List<MyTransfer>): RecyclerView.Adapter<MyTransferAdapter.Vh>() {

    inner class Vh(var itemTransferRvBinding: ItemTransferRvBinding):RecyclerView.ViewHolder(itemTransferRvBinding.root){

    fun onBind(myTransfer: MyTransfer, position: Int){
        itemTransferRvBinding.apply {
            tvSumma.text = myTransfer.Summa.toString()+" so'm"
            tvDate.text = myTransfer.date
            tvCardTo.text = myTransfer.toCardId.toString()
            tvCardFrom.text = myTransfer.fromCardId.toString()
        }
    }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemTransferRvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}