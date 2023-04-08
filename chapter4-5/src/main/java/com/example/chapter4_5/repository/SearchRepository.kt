package com.example.chapter4_5.repository

import com.example.chapter4_5.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    fun search(query: String) : Observable<List<ListItem>>
}