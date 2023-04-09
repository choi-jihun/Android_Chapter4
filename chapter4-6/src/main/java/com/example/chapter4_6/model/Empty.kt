package com.example.chapter4_6.model

class Empty: ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}