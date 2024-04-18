package com.example.empowerassessment.screens.main

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
import com.example.empowerassessment.screens.details.DetailsActivity
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.utils.createBorderDrawable
import com.example.empowerassessment.utils.delegationTranslate
import com.example.empowerassessment.utils.dpToPx

//RecyclerView Adapter for the Main Activity
class BeneficiaryAdapter(private var items: List<Beneficiary>, private val context: Context) :
    RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

    //variable for the utility function
    private val backgroundDrawable = createBorderDrawable()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LinearLayout(parent.context).apply {
            orientation = LinearLayout.VERTICAL
            //This keeps the Linear Layout in the Main Activity as the main layout and creates a
            //RecyclerView on top of it
            layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            //more customization with utility functions
            background = backgroundDrawable
            setPadding(context.dpToPx(8), context.dpToPx(8), context.dpToPx(8), context.dpToPx(8))
        }

        //TextViews set up along with customization
        val firstNameTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val lastNameTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val beneTypeTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val designationTextView = TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textSize = 16f
            gravity = Gravity.CENTER
        }

        //added into the itemView Layout
        itemView.addView(firstNameTextView)
        itemView.addView(lastNameTextView)
        itemView.addView(beneTypeTextView)
        itemView.addView(designationTextView)

        //variable created for the onClickListener
        val viewHolder = ViewHolder(
            itemView,
            firstNameTextView,
            lastNameTextView,
            beneTypeTextView,
            designationTextView
        )

        itemView.setOnClickListener {
            val position = viewHolder.absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val beneficiary = items[position]
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("SSN", beneficiary.socialSecurityNumber)
                context.startActivity(intent)

            }
        }
        //And is returned here to complete the full setup
        return viewHolder
    }

    //This is to assign each textView with the corresponding dat from th data class
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.firstNameTextView.text = "First Name: ${item.firstName}"
        holder.lastNameTextView.text = "Last Name: ${item.lastName}"
        holder.beneTypeTextView.text = "Relations: ${item.beneType}"
        holder.designationTextView.text =
            "Designation: ${delegationTranslate(item.designationCode)}"
    }

    override fun getItemCount() = items.size

    //function is used to up date the adapter and display new data
    fun updateData(newData: List<Beneficiary>) {
        items = newData
        notifyDataSetChanged()
    }


    //item view is declared here so that all the other text views inside of it
    // can be accounted for in the ViewHolder
    class ViewHolder(
        itemView: View,
        val firstNameTextView: TextView,
        val lastNameTextView: TextView,
        val beneTypeTextView: TextView,
        val designationTextView: TextView
    ) : RecyclerView.ViewHolder(itemView)
}