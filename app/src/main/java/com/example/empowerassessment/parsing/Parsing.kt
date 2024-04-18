package com.example.empowerassessment.parsing

import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.models.BeneficiaryAddress
import org.json.JSONArray

//Parsing Function used to map out the JSON to the Beneficiary Data Class
fun parseBeneficiaries(jsonString: String): List<Beneficiary> {
    val jsonArray = JSONArray(jsonString)
    val beneficiaries = mutableListOf<Beneficiary>()

    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        val addressObject = jsonObject.getJSONObject("beneficiaryAddress")

        //address setup first so that in can be added to the main data class
        val address = BeneficiaryAddress(
            firstLineMailing = addressObject.getString("firstLineMailing"),
            scndLineMailing = addressObject.optString("scndLineMailing", null),
            city = addressObject.getString("city"),
            zipCode = addressObject.getString("zipCode"),
            stateCode = addressObject.getString("stateCode"),
            country = addressObject.getString("country")
        )

        val beneficiary = Beneficiary(
            lastName = jsonObject.getString("lastName"),
            firstName = jsonObject.getString("firstName"),
            middleName = jsonObject.optString("middleName", null),
            designationCode = jsonObject.getString("designationCode"),
            beneType = jsonObject.getString("beneType"),
            socialSecurityNumber = jsonObject.getString("socialSecurityNumber"),
            dateOfBirth = jsonObject.getString("dateOfBirth"),
            phoneNumber = jsonObject.getString("phoneNumber"),
            beneficiaryAddress = address // added here
        )
        beneficiaries.add(beneficiary)

    }
    return beneficiaries
}