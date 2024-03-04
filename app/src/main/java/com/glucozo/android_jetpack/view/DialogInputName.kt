package com.glucozo.android_jetpack.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import com.glucozo.android_jetpack.R
import com.glucozo.android_jetpack.databinding.DialogInputNameBinding

class DialogInputName {
    private lateinit var binding: DialogInputNameBinding
    private lateinit var dialog: Dialog
    private lateinit var dialogResult: DialogResult

    fun onCreate(
        context: Context
    ) {
        binding = DialogInputNameBinding.inflate(LayoutInflater.from(context))
        dialog = Dialog(context)
        setupView(context)
        setAction()
        configDialog()
        dialog.show()
    }

    private fun setupView(context: Context) {
        binding.edtInputName.hint = context.getString(R.string.hind_edit_input_name)
        binding.btnAccept.text = context.getString(R.string.next_to)
    }

    private fun setAction() {
        binding.btnAccept.setOnClickListener {
            dialogResult.finish(binding.edtInputName.text.toString())
            dialog.dismiss()
        }
    }
    private fun configDialog() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(binding.root)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    fun setDialogResult(result: DialogResult) {
        this.dialogResult = result
    }

    interface DialogResult {
        fun finish(name: String)
    }
}

