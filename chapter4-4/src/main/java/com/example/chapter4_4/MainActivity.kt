package com.example.chapter4_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4_4.databinding.ActivityMainBinding
import com.example.chapter4_4.mvc.MvcActivity
import com.example.chapter4_4.mvi.MviActivity
import com.example.chapter4_4.mvp.MvpActivity
import com.example.chapter4_4.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
    }

    fun openMvc() {
        startActivity(Intent(this,MvcActivity::class.java))
    }

    fun openMvp() {
        startActivity(Intent(this,MvpActivity::class.java))
    }

    fun openMvvm() {
        startActivity(Intent(this,MvvmActivity::class.java))
    }

    fun openMvi() {
        startActivity(Intent(this,MviActivity::class.java))
    }
}