package com.example.empowerassessment.screens.details

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.empowerassessment.R
import com.example.empowerassessment.utils.delegationTranslate
import com.example.empowerassessment.utils.dpToPx
import com.example.empowerassessment.utils.formattedDate
import com.example.empowerassessment.utils.formattedPhoneNumber
import com.example.empowerassessment.utils.formattedSSN

class DetailsActivity : AppCompatActivity() {
    //Needs to be declared before the start of onCreate
    private lateinit var viewModel: BeneficiaryDetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewModel is initialized here
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
            .get(BeneficiaryDetailViewModel::class.java)

        //the main layout for the activity is setup here
        val layout = LinearLayout(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.VERTICAL
            setPadding(
                context.dpToPx(16),
                context.dpToPx(16),
                context.dpToPx(16),
                context.dpToPx(16)
            )
        }

        //each textView that is used is initialized and customized individually here,
        // achieving a non-XML Layout setup
        val firstNameTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val lastNameTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val beneTypeTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val designationTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val SSNTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val dateOfBirthTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val phoneNumberTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }
        val addressTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 25f
            setTypeface(null, Typeface.BOLD)
        }
        val streetAndCityTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }

        val stateZipAndCountryTextView = TextView(this).apply {
            layoutParams =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            textSize = 20f
        }


        //then the view is added to the main layout
        layout.addView(firstNameTextView)
        layout.addView(lastNameTextView)
        layout.addView(beneTypeTextView)
        layout.addView(designationTextView)
        layout.addView(SSNTextView)
        layout.addView(dateOfBirthTextView)
        layout.addView(phoneNumberTextView)
        layout.addView(addressTextView)
        layout.addView(streetAndCityTextView)
        layout.addView(stateZipAndCountryTextView)



        //then the layout with all the text views is set for the activity to display for the user
        setContentView(layout)

        //variable is set up to receive the data from the Main Activity
        //then is plugged into the viewmodel function to retrieve the beneficiary data
        val ssn = intent.getStringExtra("SSN")
        viewModel.loadBeneficiaryBySSN(ssn!!)

        //This is where the beneficiary data is connected to the TextView
        viewModel.selectedBeneficiary.observe(
            this
        ) { beneficiary ->
            firstNameTextView.text = "First Name: ${beneficiary.firstName}"
            lastNameTextView.text = "Last Name: ${beneficiary.lastName}"
            beneTypeTextView.text = "Relation: ${beneficiary.beneType}"
            designationTextView.text =
                "Designation: ${delegationTranslate(beneficiary.designationCode)}"
            SSNTextView.text = "SSN: ${formattedSSN(beneficiary.socialSecurityNumber)}"
            dateOfBirthTextView.text = "DOB: ${formattedDate(beneficiary.dateOfBirth)}"
            phoneNumberTextView.text = "Phone#: ${formattedPhoneNumber(beneficiary.phoneNumber)}"
            addressTextView.text = getString(R.string.address_string)
            streetAndCityTextView.text =
                "${beneficiary.beneficiaryAddress.firstLineMailing}, ${beneficiary.beneficiaryAddress.city},"
            stateZipAndCountryTextView.text =
                "${beneficiary.beneficiaryAddress.stateCode} ${beneficiary.beneficiaryAddress.zipCode}, ${beneficiary.beneficiaryAddress.country}"

        }


    }
}