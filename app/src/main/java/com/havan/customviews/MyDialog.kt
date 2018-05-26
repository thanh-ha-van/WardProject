package com.havan.customviews

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.havan.constants.DialogType
import com.havan.hereever.R

// Created by HaVan on 5/26/2018

class MyDialog(context: Context, private var interFace: ClickListener?) {

    private val myDialog: Dialog

    init {
        myDialog = Dialog(context, R.style.PauseDialog)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setCancelable(false)
        if (myDialog.window != null)
            myDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.setCanceledOnTouchOutside(false)
        myDialog.setContentView(R.layout.view_my_custom_dialog)
    }

    fun setListener(listener: ClickListener) {
        this.interFace = listener
    }

    fun showAlertDialog(type: Int, title: String, message: String) {

        bindView(title, message)
        when (type) {
            DialogType.TYPE_CONFIRM -> {

            }
            DialogType.TYPE_ERROR -> {
            }
            DialogType.TYPE_INFO -> {
            }
            DialogType.TYPE_WARNING -> {
            }
        }

        myDialog.show()

    }

    private fun bindView(title: String, message: String) {
        val tvContent = myDialog.findViewById<MyTextView>(R.id.tv_content)
        val tvTitle = myDialog.findViewById<MyTextView>(R.id.tv_title)
        val tvCancel = myDialog.findViewById<MyTextView>(R.id.btn_cancel_dialog)
        val tvOK = myDialog.findViewById<MyTextView>(R.id.btn_ok_dialog)
        tvTitle.text = title
        tvContent.text = message
        tvCancel.setOnClickListener {
            interFace!!.onNoClicked()
            myDialog.dismiss()
        }

        tvOK.setOnClickListener {
            interFace!!.onYesClicked()
            myDialog.dismiss()
        }

    }

    interface ClickListener {

        fun onYesClicked()

        fun onNoClicked()
    }
}
