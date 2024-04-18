package com.example.empowerassessment.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import java.lang.IllegalArgumentException

//used to change dp to an int so that it can be used to customise TextViews
fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

//used to create a border for the containers in the RecyclerView
fun createBorderDrawable(): Drawable {
    val shape = ShapeDrawable(RectShape())
    shape.paint.apply {
        color = Color.GRAY
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }
    return shape
}

//used to translate the delegation code for each beneficiary
fun delegationTranslate(input: String): String {
    return when (input) {
        "P" -> "Primary"
        "C" -> "Contingent"
        else -> "Not Available"
    }
}

//used to display the date in MM/DD/YYYY format
fun formattedDate(input: String): String {
    if (input.length != 8) throw IllegalArgumentException("Date was not entered correctly")

    val month = input.substring(0, 2)
    val day = input.substring(2, 4)
    val year = input.substring(4, 8)

    return "$month/$day/$year"
}

//used to display the phone number in XXX-XXX-XXXX
fun formattedPhoneNumber(input: String): String {
    if (input.length != 10) throw IllegalArgumentException("Phone Number was not entered correctly")

    val areaCode = input.substring(0, 3)
    val firstThree = input.substring(3, 6)
    val lastFour = input.substring(6, 10)

    return "$areaCode-$firstThree-$lastFour"
}

//used to display the SSN in XXX-XX-XXXX
fun formattedSSN(input: String): String {
    if (input.length != 9) throw IllegalArgumentException("SSN was not entered correctly")

    val firstThree = input.substring(0, 3)
    val midTwo = input.substring(3, 5)
    val lastFour = input.substring(5, 9)

    return "$firstThree-$midTwo-$lastFour"
}