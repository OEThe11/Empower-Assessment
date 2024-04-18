package com.example.empowerassessment.screens.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.repository.BeneficiaryRepository

//ViewModel for the Details Activity once Beneficiary is selected
class BeneficiaryDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = BeneficiaryRepository(application)

    //LiveData setup to Monitor Data Changes & Lifecycle Awareness
    private val _selectedBeneficiary = MutableLiveData<Beneficiary>()
    val selectedBeneficiary: LiveData<Beneficiary> = _selectedBeneficiary

    //brings up the repository function to the viewmodel layer
    fun loadBeneficiaryBySSN(ssn: String) {
        val beneficiary = repository.getBeneficiaryBySSN(ssn)
        _selectedBeneficiary.value = beneficiary
    }
}