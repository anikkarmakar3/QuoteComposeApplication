package com.lock.quotecomposeapplication

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.lock.quotecomposeapplication.model.Quote
import com.lock.quotecomposeapplication.screens.Pages
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

object DataManager {
    var data = emptyArray<Quote?>()
    var currentQuote : Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("dummy.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote?>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if(currentPage.value == Pages.LISTING){
            currentQuote= quote
            currentPage.value = Pages.DETAILS
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}