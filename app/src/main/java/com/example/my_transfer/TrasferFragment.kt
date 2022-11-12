package com.example.my_transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.my_transfer.adapters.MyTransferAdapter
import com.example.my_transfer.databinding.FragmentTrasferBinding
import com.example.my_transfer.db.AppDatabase
import com.example.my_transfer.db.MyCard
import com.example.my_transfer.db.MyTransfer

class TrasferFragment : Fragment() {
    private lateinit var binding: FragmentTrasferBinding
    private lateinit var cardList: ArrayList<MyCard>
    private lateinit var cardNameList: ArrayList<String>
    private lateinit var appDatabase: AppDatabase
    private lateinit var listTransfer: ArrayList<MyTransfer>
    private lateinit var myTransferAdapter: MyTransferAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrasferBinding.inflate(layoutInflater)
        appDatabase = AppDatabase.getInstance(binding.root.context)



        loadCard()
        setTransfer()
        showAllTransfer()

        return binding.root
    }

    private fun setTransfer() {
        binding.btnSave.setOnClickListener {
            val myTransfer = MyTransfer(
               cardList[binding.SpinnerFromCart.selectedItemPosition].id,
                cardList[binding.SpinnerToCart.selectedItemPosition].id,
                binding.edtNumber.text.toString().toDouble()
            )
            appDatabase.myDao().addTransfer(myTransfer)
            showAllTransfer()

        }
    }

    fun showAllTransfer(){
listTransfer = ArrayList()
        listTransfer.addAll(appDatabase.myDao().getTransfers())
        myTransferAdapter = MyTransferAdapter(listTransfer)
        binding.rvTransfer.adapter = myTransferAdapter

    }

    private fun loadCard() {
        cardList = ArrayList()
        cardList.addAll(appDatabase.myDao().getcards())
        cardNameList = ArrayList()

        cardList.forEach {
            cardNameList.add(it.name!!)
        }

        val spinnerAdapter = ArrayAdapter<String>(binding.root.context,
            android.R.layout.simple_list_item_1,
            cardNameList)

        binding.SpinnerToCart.adapter = spinnerAdapter
        binding.SpinnerFromCart.adapter = spinnerAdapter


    }


}