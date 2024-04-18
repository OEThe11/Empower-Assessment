package com.example.empowerassessment.main

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.empowerassessment.details.DetailsActivity
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.utils.createBorderDrawable
import com.example.empowerassessment.utils.dpToPx

class BeneficiaryAdapter(private var items: List<Beneficiary>, private val context: Context):
    RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>(){

        private val backgroundDrawable = createBorderDrawable()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
      val itemView = LinearLayout(parent.context).apply {
          orientation = LinearLayout.VERTICAL
          //This uses the Linear Layout in the Main Activity, keeping a clean layout structure
          layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
          background = backgroundDrawable
          setPadding(context.dpToPx(8), context.dpToPx(8), context.dpToPx(8), context.dpToPx(8))
      }

        val firstNameTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val lastNameTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val beneTypeTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val designationTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            textSize = 16f
            gravity = Gravity.CENTER
        }

        itemView.addView(firstNameTextView)
        itemView.addView(lastNameTextView)
        itemView.addView(beneTypeTextView)
        itemView.addView(designationTextView)

        val viewHolder = ViewHolder(itemView, firstNameTextView, lastNameTextView, beneTypeTextView, designationTextView)

        itemView.setOnClickListener{
            val position = viewHolder.absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                val beneficiary = items[position]
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("SSN", beneficiary.socialSecurityNumber)
                context.startActivity(intent)

            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.firstNameTextView.text = "First Name: ${item.firstName}"
        holder.lastNameTextView.text = "Last Name: ${item.lastName}"
        holder.beneTypeTextView.text = "Relations: ${item.beneType}"
        holder.designationTextView.text = "Designation: ${item.designationCode}"
    }

    override fun getItemCount() = items.size

    fun updateData(newData: List<Beneficiary>){
        items = newData
        notifyDataSetChanged()
    }



    class ViewHolder(
       itemView: View,
        val firstNameTextView: TextView,
        val lastNameTextView: TextView,
        val beneTypeTextView: TextView,
        val designationTextView: TextView
    ): RecyclerView.ViewHolder(itemView)
}