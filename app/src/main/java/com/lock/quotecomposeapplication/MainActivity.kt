package com.lock.quotecomposeapplication

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.lock.quotecomposeapplication.screens.Pages
import com.lock.quotecomposeapplication.screens.quoteList
import com.lock.quotecomposeapplication.screens.quoteListItemDetails
import com.lock.quotecomposeapplication.screens.quoteListScreen
import com.lock.quotecomposeapplication.ui.theme.QuoteComposeApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
private fun App() {

    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING){
            quoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let {
                quoteListItemDetails(data = it)
            }
        }

    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

