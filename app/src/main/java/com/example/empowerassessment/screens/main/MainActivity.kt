package com.example.empowerassessment.screens.main

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.empowerassessment.R

class MainActivity : AppCompatActivity() {
    //Declarations needed before onCreate
    private lateinit var mainLayout: LinearLayout
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialize ViewModel
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
            .get(MainViewModel::class.java)

        //main layout is initialized here
        //Declaring it first needed to happen so that the layout could be used
        //in the Recycler View Adapter class
        mainLayout = LinearLayout(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
        }

        //recyclerView is initialized here
        recyclerView = RecyclerView(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        //we connect the adapter class to the recyclerView variable
        val adapter = BeneficiaryAdapter(emptyList(), this)
        recyclerView.adapter = adapter

        //This Text View was created to Specify Who the Beneficiaries are for.
        val accountHolder = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            text = context.getString(R.string.account_holders_name)
            textSize = 27f
            gravity = Gravity.CENTER_HORIZONTAL
            setTypeface(null, Typeface.BOLD)
        }

        //Both TextView and RecyclerView is added into the Main Layout
        mainLayout.addView(accountHolder)
        mainLayout.addView(recyclerView)

        //then the layout with all the text views is set for the activity to display for the user
        setContentView(mainLayout)

        //LiveData observes the changes and updates the adapter
        viewModel.beneficiaries.observe(this) { beneficiaries ->
            if (beneficiaries != null) {
                adapter.updateData(beneficiaries)
            }
        }


    }
}
