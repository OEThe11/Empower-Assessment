package com.example.empowerassessment.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.repository.BeneficiaryRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    //repository is initialized here
    private val repository = BeneficiaryRepository(application)

    //LiveData setup to Monitor Data Changes & Lifecycle Awareness
    private val _beneficiaries = MutableLiveData<List<Beneficiary>?>()
    val beneficiaries: LiveData<List<Beneficiary>?> = _beneficiaries

    //this function loads the list up as soon as the app starts
    init {
        loadBeneficiaries()
    }

    //brings up the repository function to the viewmodel layer
    private fun loadBeneficiaries() {
        val data = repository.getBeneficiaries()
        _beneficiaries.value = data
    }

}