package com.havan.customviews

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.havan.hereever.R

// Created by HaVan on 5/26/2018

class CustomYesNoDialog(activity: Activity, private var interFace: YesNoInterFace?) {

    private val alertDialog: Dialog

    init {
        alertDialog = Dialog(activity, R.style.PauseDialog)
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.setCancelable(false)
        if (alertDialog.window != null)
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setContentView(R.layout.view_my_custom_dialog)
    }

    fun setListener(yesNoInterFace: YesNoInterFace) {
        this.interFace = yesNoInterFace
    }

    fun showAlertDialog( type: Int,  title: String, message: String) {

        val tvContent = alertDialog.findViewById<MyTextView>(R.id.tv_content)
        val tvTitle = alertDialog.findViewById<MyTextView>(R.id.tv_title)
        val tvCancel = alertDialog.findViewById<MyTextView>(R.id.btn_cancel_dialog)
        val tvOK = alertDialog.findViewById<MyTextView>(R.id.btn_ok_dialog)
        tvTitle.setText(title)
        tvContent.setText(message)

        tvCancel.setOnClickListener {
            interFace!!.onNoClicked()
            alertDialog.dismiss()
        }

        tvOK.setOnClickListener {
            interFace!!.onYesClicked()
            alertDialog.dismiss()
        }

        alertDialog.show()

    }

    interface YesNoInterFace {

        fun onYesClicked()

        fun onNoClicked()
    }
}
