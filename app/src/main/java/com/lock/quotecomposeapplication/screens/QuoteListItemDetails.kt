package com.lock.quotecomposeapplication.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lock.quotecomposeapplication.DataManager
import com.lock.quotecomposeapplication.model.Quote


@Composable
fun quoteListItemDetails(data: Quote?) {
    BackHandler() {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(Color(0xFF2be4dc), Color(0xFF243484))
                )
            )
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.padding(30.dp)
        ) {
            Column(modifier = Modifier.padding(32.dp)) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "Quote",
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = data?.text.toString(),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Text(
                    text = data?.author.toString(),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
