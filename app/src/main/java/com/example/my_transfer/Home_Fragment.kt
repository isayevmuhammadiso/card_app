package com.example.my_transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.my_transfer.databinding.FragmentHomeBinding

class Home_Fragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.cardButton.setOnClickListener {
            findNavController().navigate(R.id.cardsFragment)
        }

binding.transferButton.setOnClickListener {

    findNavController().navigate(R.id.trasferFragment)

}

        return binding.root
    }


}