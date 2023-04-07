package com.example.chapter4_4.mvi

import com.example.chapter4_4.mvi.model.Image

sealed class MviState{
    object Idle: MviState()
    object Loading: MviState()
    data class LoadImage(val image: Image, val count: Int): MviState()
}
