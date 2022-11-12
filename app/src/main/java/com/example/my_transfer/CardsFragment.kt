package com.example.my_transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.my_transfer.adapters.MyCardAdapter
import com.example.my_transfer.databinding.FragmentCardsBinding
import com.example.my_transfer.db.AppDatabase
import com.example.my_transfer.db.MyCard

class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private lateinit var list: ArrayList<MyCard>
    private lateinit var appDatabase: AppDatabase
    private lateinit var myCardAdapter: MyCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(layoutInflater)

        appDatabase = AppDatabase.getInstance(binding.root.context)
        list = ArrayList()
        list.addAll(appDatabase.myDao().getcards())
        myCardAdapter = MyCardAdapter(list)

        binding.apply {
            rvCard.adapter = myCardAdapter

            btnSave.setOnClickListener {
                val myCard = MyCard(
                    edtName.text.toString(),
                    edtNumber.text.toString().toLong()
                )
                appDatabase.myDao().addCard(myCard)
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                list.add(myCard)
                myCardAdapter.notifyItemInserted(list.size - 1)
            }
        }

        return binding.root
    }
}