package com.glucozo.android_jetpack.login_email.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.glucozo.android_jetpack.databinding.ActivitySignInBinding
import com.glucozo.android_jetpack.databinding.ActivitySignUpBinding
import com.glucozo.android_jetpack.view.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var test: GoogleSignInAccount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()


        binding = ActivitySignInBinding.inflate(layoutInflater)
        eventOnClick()
        setContentView(binding.root)
    }

    private fun eventOnClick() {
        binding.button.setOnClickListener {
            setValueTextView()
        }
        binding.textView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setValueTextView() {
        val email = binding.emailEt.text.toString()
        val pass = binding.passET.text.toString()

        if (email.isNotEmpty() && pass.isNotEmpty()) {

            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Toast.makeText(this, "Password is not matching", Toast.LENGTH_LONG).show()
        }


    }

    override fun onStart() {
        test  = GoogleSignInAccount.createDefault()
        test.email

        super.onStart()
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}