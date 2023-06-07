package com.example.khatabook.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.khatabook.R
import com.example.khatabook.TransactionModal
import com.example.khatabook.databinding.FragmentTransactionBinding
import com.example.khatabook.databinding.FragmentAddBinding
import com.example.khatabook.databinding.RecycleviewnaBinding

class TransAdapter : RecyclerView.Adapter<TransAdapter.TransHolder>() {
//
//    var deteleclick = detele
//    var updateClick = update
    lateinit var transaction: ArrayList<TransactionModal>

    class TransHolder(itemView: RecycleviewnaBinding) : RecyclerView.ViewHolder(itemView.root) {

        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransHolder {

        var binding = RecycleviewnaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TransHolder(binding)
    }

    override fun getItemCount(): Int {

        return transaction.size

    }

    override fun onBindViewHolder(
        holder: TransHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {

        holder.binding.apply {

            txtamount.text = transaction.get(position).amt.toString()
            txtcategory.text = transaction.get(position).category
            txtnotes.text = transaction.get(position).note
            txtdate.text = transaction.get(position).time

        }

    }

    fun addTrans(transaction: ArrayList<TransactionModal>) {
        this.transaction = transaction
    }

    fun update(transaction: ArrayList<TransactionModal>) {

        this.transaction = transaction

        notifyDataSetChanged()
    }

    fun setTrans(translist: java.util.ArrayList<TransactionModal>) {
       this.transaction = translist
    }
}