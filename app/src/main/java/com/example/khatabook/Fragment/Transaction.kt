package com.example.khatabook.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.khatabook.Adapter.TransAdapter
import com.example.khatabook.DBhelper.DBhelper
import com.example.khatabook.R
import com.example.khatabook.TransactionModal
import com.example.khatabook.databinding.FragmentTransactionBinding
import com.example.khatabook.databinding.RecycleviewnaBinding

class Transaction : Fragment() {

    var translist = ArrayList<TransactionModal>()
    lateinit var aduptor : TransAdapter
    lateinit var binding: FragmentTransactionBinding
    lateinit var DBhelper: DBhelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTransactionBinding.inflate(layoutInflater)

        DBhelper = DBhelper(context)
        translist = DBhelper.getTransaction()

        aduptor = TransAdapter()
        if (translist.size>0) {
            aduptor.setTrans(translist)

            binding.rcvlist.layoutManager = LinearLayoutManager(context)
            binding.rcvlist.adapter=aduptor
        }




        return binding.root
    }
}