package com.example.empowerassessment.repository

import android.content.Context
import com.example.empowerassessment.models.Beneficiary
import com.example.empowerassessment.parsing.parseBeneficiaries
import java.io.IOException
import java.io.InputStream

class BeneficiaryRepository(private val context: Context) {

    fun getBeneficiaries(): List<Beneficiary>? {
        val jsonString = loadJSONFromRaw("beneficiaries.json")
        return jsonString?.let{ parseBeneficiaries(it) }
    }

    fun getBeneficiaryBySSN(ssn: String): Beneficiary? {
        val beneficiaries = getBeneficiaries()
        return beneficiaries?.find { it.socialSecurityNumber == ssn }
    }

    private fun loadJSONFromRaw(fileName: String): String? {
        return try {
          val resourceId = context.resources.getIdentifier(
              fileName.substringBefore("."),
              "raw",
              context.packageName
              )
            val inputStream = context.resources.openRawResource(resourceId)
            inputStream.bufferedReader().use { it.readText() }
        } catch (e: IOException){
            e.printStackTrace()
            null
        }

    }

}