package com.lock.quotecomposeapplication.screens

import androidx.compose.runtime.Composable
import com.lock.quotecomposeapplication.model.Quote


@Composable
fun quoteListScreen(data:Array<Quote?>,onClick:(quote:Quote)-> Unit) {
    quoteList(data = data,onClick)
}

enum class Pages{
    LISTING,
    DETAILS
}
