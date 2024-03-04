package com.glucozo.android_jetpack.view

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.view.animation.LinearInterpolator
import android.widget.AbsoluteLayout
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnLayout
import com.glucozo.android_jetpack.R
import com.glucozo.android_jetpack.databinding.ActivityTestAnimationBinding
import java.util.Random


class TestAnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestAnimationBinding
    private lateinit var mediaPlayer: MediaPlayer
    var nameUse : String = ""

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestAnimationBinding.inflate(layoutInflater)
        setupView()
        action()
        setMenu()
        changeColorTextView()
        binding.edtStk.inputType = InputType.TYPE_CLASS_NUMBER
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        showDialogInputName()
        anyLocation()

    }

    private fun showDialogInputName() {
        val dialog = DialogInputName()
        dialog.onCreate(this)
        dialog.setDialogResult(object : DialogInputName.DialogResult {
            override fun finish(name: String) {
                nameUse = name
                binding.tvSayHi.text = String.format(
                    "%s",
                    "Chào $name đến năm mới rồi. $name có muốn nhận lì xì không "
                )
            }
        })
    }

    private fun setupView() {
        binding.btnAni.text = getString(R.string.lucky_money)
    }

    private fun changeColorTextView() {
        val a = ObjectAnimator.ofInt(
            binding.tvSayHi,
            "textColor",
            Color.GREEN,
            Color.RED,
            Color.BLUE,
            Color.YELLOW,
            Color.BLACK,
            Color.DKGRAY,
            Color.CYAN,
            Color.DKGRAY,
            Color.LTGRAY
        )
        a.interpolator = LinearInterpolator()
        a.duration = 3000
        a.repeatCount = ValueAnimator.INFINITE
        a.repeatMode = ValueAnimator.REVERSE
        a.setEvaluator(ArgbEvaluator())
        val t = AnimatorSet()
        t.play(a)
        t.start()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun action() {
        binding.btnAni.setOnClickListener {
            onClickMove()
            playMusic()
        }
        binding.noAccept.setOnClickListener {
            showDialogNoAccept()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun showDialogNoAccept() {
        val dialog = DialogNoAcceptLuckyMoney()
        dialog.onCreate(this,nameUse)
        dialog.setDialogResult(object : DialogNoAcceptLuckyMoney.DialogResult {
            override fun finish() {
            }
        })
    }

    private fun setMenu() {
        val feelings = resources.getStringArray(R.array.feelings)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, feelings)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    private fun playMusic() {
        if (!this::mediaPlayer.isInitialized) {
            mediaPlayer = MediaPlayer.create(this, R.raw.lixi)
        }
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    private fun onClickMove() {
        anyLocation()
    }
   private fun anyLocation(){
        binding.btnAni.doOnLayout { view ->
            val heightButton = view.height
            val widthButton = view.width

            binding.container.doOnLayout {
                val height = it.height
                val width = it.width

                val params = binding.btnAni.layoutParams as AbsoluteLayout.LayoutParams
                params.x = Random().nextInt(width - widthButton)
                params.y = Random().nextInt(height - heightButton)
                binding.btnAni.layoutParams = params
            }
        }
    }
}