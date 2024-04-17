package com.example.empowerassessment.main

import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.empowerassessment.models.Beneficiary

class BeneficiaryAdapter(private var items: List<Beneficiary>):
    RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val textView = TextView(parent.context)
        textView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = "${item.firstName} ${item.lastName} ${item.beneType} ${item.designationCode}"
    }

    override fun getItemCount() = items.size

    fun updateData(newData: List<Beneficiary>){
        items = newData
        notifyDataSetChanged()
    }


    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}