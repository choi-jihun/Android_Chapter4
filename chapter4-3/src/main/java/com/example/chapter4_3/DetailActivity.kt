package com.example.chapter4_3

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.chapter4_3.databinding.ActivityDetailBinding
import com.example.chapter4_3.model.DetailItem
import com.example.chapter4_3.model.Type
import java.util.Calendar

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val adapter = DetailListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

        adapter.submitList(mockData())
    }

    private fun initView() {
        binding.cardTitleTextView.text = intent.getStringExtra(CARD_NAME)
        binding.cardLayout.backgroundTintList =
            intent.getParcelableExtra(CARD_COLOR) as? ColorStateList
        binding.recyclerView.adapter = adapter
    }

    private fun mockData(): List<DetailItem> {
        fun createDate(year: Int, month: Int, day: Int) = Calendar.getInstance().apply {
            set(year, month, day)
        }.time

        val list = mutableListOf<DetailItem>().apply {
            add(DetailItem(1, createDate(2023, 1, 1), "A상점", 24000, Type.PAY))
            add(DetailItem(2, createDate(2023, 1, 1), "B상점", 15000, Type.CANCEL))
            add(DetailItem(3, createDate(2023, 1, 5), "C상점", 20000, Type.PAY))
        }
        return list
    }

    companion object {
        private const val CARD_NAME = "CARD_NAME"
        private const val CARD_COLOR = "CARD_COLOR"

        fun start(
            context: Context,
            cardName: String,
            cardColor: ColorStateList?,
            optionsCompat: ActivityOptionsCompat
        ) {
            Intent(context, DetailActivity::class.java).apply {
                putExtra(CARD_NAME, cardName)
                putExtra(CARD_COLOR, cardColor)
            }.run {
                context.startActivity(this, optionsCompat.toBundle())
            }
        }

    }
}