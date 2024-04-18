package com.example.empowerassessment.details

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.empowerassessment.R
import com.example.empowerassessment.utils.dpToPx

class DetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: BeneficiaryDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(BeneficiaryDetailViewModel::class.java)

        val layout = LinearLayout(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            setPadding(context.dpToPx(16), context.dpToPx(16), context.dpToPx(16), context.dpToPx(16))
        }

        val firstNameTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val lastNameTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val beneTypeTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val designationTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val SSNTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val dateOfBirthTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val phoneNumberTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val addressTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val firstLineATextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val cityTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val zipCodeTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val stateCodeTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val countryTextView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }

        layout.addView(firstNameTextView)
        layout.addView(lastNameTextView)
        layout.addView(beneTypeTextView)
        layout.addView(designationTextView)
        layout.addView(SSNTextView)
        layout.addView(dateOfBirthTextView)
        layout.addView(phoneNumberTextView)
        layout.addView(addressTextView)
        layout.addView(firstLineATextView)
        layout.addView(cityTextView)
        layout.addView(stateCodeTextView)
        layout.addView(zipCodeTextView)
        layout.addView(countryTextView)


        setContentView(layout)

        val ssn = intent.getStringExtra("SSN")
        viewModel.loadBeneficiaryBySSN(ssn!!)

        viewModel.selectedBeneficiary.observe(this
        ) { beneficiary ->
            firstNameTextView.text = "First Name: ${beneficiary.firstName}"
            lastNameTextView.text = "Last Name: ${beneficiary.lastName}"
            beneTypeTextView.text = "Relation: ${beneficiary.beneType}"
            designationTextView.text = "Designation: ${beneficiary.designationCode}"
            SSNTextView.text = "SSN: ${beneficiary.socialSecurityNumber}"
            dateOfBirthTextView.text = "DOB: ${beneficiary.dateOfBirth}"
            phoneNumberTextView.text = "Phone#: ${beneficiary.phoneNumber}"
            addressTextView.text = "ADDRESS"
            firstLineATextView.text = "${beneficiary.beneficiaryAddress.firstLineMailing},"
            cityTextView.text = "${beneficiary.beneficiaryAddress.city},"
            stateCodeTextView.text = "${beneficiary.beneficiaryAddress.stateCode}"
            zipCodeTextView.text = "${beneficiary.beneficiaryAddress.zipCode},"
            countryTextView.text = "${beneficiary.beneficiaryAddress.country}"
        }


    }
}