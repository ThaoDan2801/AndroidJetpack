package com.glucozo.android_jetpack.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.glucozo.android_jetpack.R
import com.glucozo.android_jetpack.databinding.DialogNotAcceptMoneyBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class DialogNoAcceptLuckyMoney {
    private lateinit var binding: DialogNotAcceptMoneyBinding
    private lateinit var dialog: Dialog
    private lateinit var dialogResult: DialogResult

    @RequiresApi(Build.VERSION_CODES.P)
    fun onCreate(
        context: Context,
        name: String,
    ) {
        binding = DialogNotAcceptMoneyBinding.inflate(LayoutInflater.from(context))
        dialog = Dialog(context)
        setupView(context, name)
        configDialog()

        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setupView(context: Context, name: String) {
        CoroutineScope(SupervisorJob()).launch(Dispatchers.IO) {
            val source = ImageDecoder.createSource(
                context.resources, R.drawable.anh_dong
            )
            val drawable = ImageDecoder.decodeDrawable(source)
            binding.imgView.post {
                binding.imgView.setImageDrawable(drawable)
                (drawable as? AnimatedImageDrawable)?.start()
            }
        }
        binding.tvTitle1.text = String.format(
            "%s",
            "Dù rất muốn lì xì, nhưng ép nhiều quá thì ngượng ngùng đôi bên"
        )
        binding.tvTitle2.text = String.format(
            "%s",
            "Nhân dịp năm mới, Chúc $name cùng gia đình nhiều sức khoẻ, gặp may mắn trong cuộc sống, và thuật lợi trong công việc."
        )
        binding.tvTitle3.text = String.format(
            "%s",
            "Chúc mừng năm mới"
        )
    }


    fun setDialogResult(result: DialogResult) {
        this.dialogResult = result
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

    interface DialogResult {
        fun finish()
    }

}