package com.example.chapter4_2.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.view.children
import com.example.chapter4_2.databinding.WidgetShuffleNumberKeyboardBinding
import java.security.Key
import kotlin.random.Random

class ShuffleNumberKeyBoard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : GridLayout(context, attrs, defStyle), View.OnClickListener {

    private var _binding: WidgetShuffleNumberKeyboardBinding? = null
    private val binding get() = _binding!!
    private var listener: KeyPadListener? = null


    init {
        _binding = WidgetShuffleNumberKeyboardBinding.inflate(LayoutInflater.from(context),this,true)
        binding.view = this
        binding.clickListener = this
        Shuffle()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }

    fun Shuffle() {
        val keyNumberArray = ArrayList<String>()
        for(i in 0..9) {
            keyNumberArray.add(i.toString())
        }

        binding.gridLayout.children.forEach { view->
            if(view is TextView && view.tag != null) {
                val randIndex = Random.nextInt(keyNumberArray.size)
                view.text = keyNumberArray[randIndex]
                keyNumberArray.removeAt(randIndex)
            }
        }
    }

    fun setKeyPadListener(keyPadListener: KeyPadListener) {
        this.listener = keyPadListener
    }

    fun onClickDelete() {
        listener?.onClickDelete()
    }

    fun onClickDone() {
        listener?.onClickDone()
    }

    interface  KeyPadListener {
        fun onClick(num: String)
        fun onClickDelete()
        fun onClickDone()
    }

    override fun onClick(v: View?) {
        if (v is TextView && v.tag != null) {
            listener?.onClick(v.text.toString())
        }
    }
}