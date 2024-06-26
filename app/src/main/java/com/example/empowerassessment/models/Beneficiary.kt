package com.example.empowerassessment.models

//Data Class used to store the JSON Data
data class Beneficiary(
    val beneType: String,
    val beneficiaryAddress: BeneficiaryAddress,
    val dateOfBirth: String,
    val designationCode: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val phoneNumber: String,
    val socialSecurityNumber: String
)