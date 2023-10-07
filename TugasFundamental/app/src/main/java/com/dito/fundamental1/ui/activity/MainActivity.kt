package com.dito.fundamental1.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dito.fundamental1.data.User
import com.dito.fundamental1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tv_username: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv_username = binding.tvMainUsername
        val username = intent.getParcelableExtra<User>("User")?.username
        tv_username.text = username

        binding.btnFragment.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }
}