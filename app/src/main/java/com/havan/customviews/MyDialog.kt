package com.havan.customviews

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.TextView
import com.havan.constants.DialogType
import com.havan.hereever.R

// Created by HaVan on 5/26/2018

public class MyDialog(context: Context, private var interFace: ClickListener?) {

    private val myDialog: Dialog = Dialog(context, R.style.pause_dialog)
    private var tvContent: TextView? = null
    private var tvTitle: TextView? = null
    private var tvCancel: TextView? = null
    private var tvOK: TextView? = null

    init {
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
                tvTitle?.setTextColor(myDialog.context.resources.getColor(R.color.green_70))
            }
            DialogType.TYPE_ERROR -> {
                tvTitle?.setTextColor(myDialog.context.resources.getColor(R.color.red_50))
                tvCancel?.visibility = View.GONE
            }
            DialogType.TYPE_INFO -> {
                tvTitle?.setTextColor(myDialog.context.resources.getColor(R.color.blue_70))
                tvCancel?.visibility = View.GONE
            }
            DialogType.TYPE_WARNING -> {
                tvTitle?.setTextColor(myDialog.context.resources.getColor(R.color.orange_70))
                tvCancel?.visibility = View.GONE
            }
        }

        myDialog.show()

    }

    public fun setNegaviteButtonText(text: String) {

        tvCancel?.text = text
    }

    public fun setPositiveButtonText(text: String) {

        tvOK?.text = text
    }

    private fun bindView(title: String, message: String) {
        tvContent = myDialog.findViewById<MyTextView>(R.id.tv_content)
        tvTitle = myDialog.findViewById<MyTextView>(R.id.tv_title)
        tvCancel = myDialog.findViewById<MyTextView>(R.id.btn_cancel_dialog)
        tvOK = myDialog.findViewById<MyTextView>(R.id.btn_ok_dialog)

        tvTitle?.text = title
        tvContent?.text = message
        tvCancel?.setOnClickListener {
            interFace!!.onCancelClicked()
            myDialog.dismiss()
        }

        tvOK?.setOnClickListener {
            interFace!!.onOKClicked()
            myDialog.dismiss()
        }

    }

    interface ClickListener {

        fun onOKClicked()

        fun onCancelClicked()
    }
}
