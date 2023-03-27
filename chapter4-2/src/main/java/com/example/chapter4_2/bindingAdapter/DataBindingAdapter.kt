package com.example.chapter4_2.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.chapter4_2.R

@BindingAdapter(value = ["code_text", "code_index"])
fun ImageView.setPin(codeText: CharSequence?, index: Int) {
    if(codeText != null) {
        if(codeText.length > index) {
            setImageResource(R.drawable.baseline_circle_24_black)
        } else {
            setImageResource(R.drawable.baseline_circle_24)
        }
    }
}