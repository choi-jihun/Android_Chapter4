package com.example.chapter4_7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter4_7.databinding.ActivityInputBinding
import com.example.chapter4_7.model.ContentEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding
    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 액션바 좌측 상단에 홈키
        (intent.getSerializableExtra(ITEM) as? ContentEntity)?.let {
            viewModel.initData(it)
        }


        viewModel.doneEvent.observe(this) {
            Toast.makeText(this, "완료!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val ITEM = "item"

        fun start(context: Context, item: ContentEntity? = null) {
            Intent(context, InputActivity::class.java).apply {
                putExtra(ITEM, item)
            }.run {
                context.startActivity(this)
            }
        }
    }

}