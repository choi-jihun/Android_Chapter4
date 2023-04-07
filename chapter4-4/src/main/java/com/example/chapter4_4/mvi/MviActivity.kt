package com.example.chapter4_4.mvi

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.chapter4_4.databinding.ActivityMviBinding
import com.example.chapter4_4.mvi.repository.ImageRepositoryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMviBinding
    private val viewModel: MviViewModel by viewModels {
        MviViewModel.MviViewModelFactory(ImageRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this
        observeViewModel()
    }

    fun loadImage() {
        lifecycleScope.launch {
            viewModel.channel.send(MviIntent.LoadImage)
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is MviState.Idle -> {
                        binding.progressView.isVisible = false
                    }
                    is MviState.Loading -> {
                        binding.progressView.isVisible = true
                    }
                    is MviState.LoadImage -> {
                        binding.progressView.isVisible = false
                        binding.imageView.run {
                            setBackgroundColor(Color.parseColor(state.image.color))
                            load(state.image.url) {
                                crossfade(300)
                            }
                        }
                        binding.imageCountTextView.text = "불러운 이미지 수 : ${state.count}"
                    }
                }
            }
        }
    }
}