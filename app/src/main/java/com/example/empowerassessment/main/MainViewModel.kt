package com.example.empowerassessment.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.repository.BeneficiaryRepository

private const val TAG = "MainViewModel"
class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = BeneficiaryRepository(application)
    private val _beneficiaries = MutableLiveData<List<Beneficiary>?>()
    val beneficiaries: LiveData<List<Beneficiary>?> = _beneficiaries


    init {
        loadBeneficiaries()
    }

    private fun loadBeneficiaries() {
        val data = repository.getBeneficiaries()
        _beneficiaries.value = data
        Log.d(TAG, "loadBeneficiaries: $data")
    }

}