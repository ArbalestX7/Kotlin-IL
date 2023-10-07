package com.dito.fundamental1.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.dito.fundamental1.R
import com.dito.fundamental1.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var edtUsername: EditText
    private lateinit var edtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtUsername = binding.edtRegisUsername
        edtPass = binding.edtRegisPassword


        binding.btnRegisRegister.setOnClickListener {
            registerCheck()
        }
        binding.btnRegisLogin.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("username", edtUsername.text.toString())
            bundle.putString("password", edtPass.text.toString())

            val i = Intent(this, LoginActivity::class.java)
            i.putExtras(bundle)
            Log.d("bundle: ", bundle.toString())
            startActivity(i)
        }
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun registerCheck() {
        val username = binding.edtRegisUsername.text.toString()
        val email = binding.edtRegisEmail.text.toString()
        val password = binding.edtRegisPassword.text.toString()
        val nama = binding.edtRegisNama.text.toString()

        if (username.isNotEmpty() && email.isNotEmpty()
            && password.isNotEmpty() && nama.isNotEmpty()
        ) {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_regis),
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_regis_gagal),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}