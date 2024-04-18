package com.example.empowerassessment.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.repository.BeneficiaryRepository

class BeneficiaryDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = BeneficiaryRepository(application)

    private val _selectedBeneficiary = MutableLiveData<Beneficiary>()
    val selectedBeneficiary: LiveData<Beneficiary> = _selectedBeneficiary

    fun loadBeneficiaryBySSN(ssn: String){
        val beneficiary = repository.getBeneficiaryBySSN(ssn)
        _selectedBeneficiary.value = beneficiary
    }
}