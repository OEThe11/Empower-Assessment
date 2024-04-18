package com.example.empowerassessment.main

import android.os.Bundle
import android.view.ViewGroup.*
import android.widget.LinearLayout
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
    private lateinit var mainLayout: LinearLayout
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialize ViewModel
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(MainViewModel::class.java)

        mainLayout = LinearLayout(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
        }

        recyclerView = RecyclerView(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        val adapter = BeneficiaryAdapter(emptyList(), this)
        recyclerView.adapter = adapter

        mainLayout.addView(recyclerView)

        setContentView(mainLayout)

        viewModel.beneficiaries.observe(this) { beneficiaries ->
            if (beneficiaries != null) {
                adapter.updateData(beneficiaries)
            }
        }


        }
    }
