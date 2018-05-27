package com.havan.customviews

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.havan.R

// Created by HaVan on 5/26/2018.

class MyTextView : AppCompatTextView {

    private val mTypeFaceList = arrayOf(
            "Roboto_Regular.ttf",
            "Roboto_Medium.ttf",
            "Roboto_Light.ttf",
            "Roboto_Bold.ttf")

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {

        val fontIndex: Int
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MyTextView, 0, 0)

        try {
            fontIndex = ta.getInteger(R.styleable.MyTextView_myFont, -1)
        } finally {
            ta.recycle()
        }

        if (fontIndex != -1) {
            val typeFace = Typeface.createFromAsset(context.assets, "fonts/" + mTypeFaceList[fontIndex])
            typeface = typeFace
        }
    }
}
