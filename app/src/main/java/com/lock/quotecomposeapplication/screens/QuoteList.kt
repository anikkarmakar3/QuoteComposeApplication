package com.lock.quotecomposeapplication.screens

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lock.quotecomposeapplication.model.Quote
import kotlin.text.Typography.quote


@Composable
fun quoteList(data: Array<Quote?>, onClick:(quote:Quote)-> Unit){
    Column(modifier = Modifier.fillMaxHeight(1f).fillMaxHeight()) {
        Text(
            text = "Quote App",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn(content = {
            items(data){
                if (it != null) {
                    quoteListItem(data = it,onClick)
                }
            }
        })
    }
}   