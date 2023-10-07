package com.dito.fundamental1.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.dito.fundamental1.R
import com.dito.fundamental1.data.User
import com.dito.fundamental1.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var edtUsername: EditText
    private lateinit var edtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtUsername = binding.edtLoginUsername
        edtPass = binding.edtLoginPassword
        setUser()

        binding.btnLogin.setOnClickListener {
            loginCheck()
        }
        binding.btnLoginRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun setUser() {
        val bundle = intent.extras
        if (bundle != null) {
            edtUsername.setText(bundle.getString("username"))
            edtPass.setText(bundle.getString("password"))
        }
    }

    private fun loginCheck() {
        val username = binding.edtLoginUsername.text.toString()
        val password = binding.edtLoginPassword.text.toString()
        val i = Intent(this, MainActivity::class.java)

        if (username.isNotEmpty() && password.isNotEmpty()
        ) {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_login),
                Snackbar.LENGTH_SHORT
            ).show()
            i.putExtra("User", User(username, password))
            Log.d("loginCheck: ", User(username, password).toString())
            startActivity(i)
        } else {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_login_gagal),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}
