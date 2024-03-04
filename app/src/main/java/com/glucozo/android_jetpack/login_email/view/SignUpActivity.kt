package com.glucozo.android_jetpack.login_email.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glucozo.android_jetpack.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(binding.root)
    }
}