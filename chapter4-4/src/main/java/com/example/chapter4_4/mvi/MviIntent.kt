package com.example.chapter4_4.mvi

sealed class MviIntent {
    object LoadImage: MviIntent()
}