package com.example.empowerassessment.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

fun createBorderDrawable(): Drawable {
    val shape = ShapeDrawable(RectShape())
    shape.paint.apply {
        color = Color.GRAY
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }
    return shape
}