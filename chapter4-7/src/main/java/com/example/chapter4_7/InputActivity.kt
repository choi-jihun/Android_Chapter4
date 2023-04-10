package com.example.chapter4_7

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter4_7.databinding.ActivityInputBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding
    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 액션바 좌측 상단에 홈키
        binding.viewModel.doneEvent.observe(this) {
            Toast.makeText(this,"완료!",Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}