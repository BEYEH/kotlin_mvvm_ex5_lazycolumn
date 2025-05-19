package com.example.kotlin_mvvvm_ex5_lazy_column.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListDemo() {
    LazyColumnDemo()
}

/**
 * Render the data which can show in the view.
 */
@Composable
fun LazyColumnDemo(){
    LazyColumn(content = {
        items (100, itemContent = {
            TextItem(text = "Index $it")
        })
    })
}


/**
 * Render all the data at once.
 */
@Composable
fun SimpleColumn() {
    // Save state in memory
    var scrollState = rememberScrollState()

    Column(
        // Scroll list in the view.
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        // Fix size list
        for (i in 1..100) {
            TextItem(text = "Item $i")
        }
    }
}

@Composable
fun TextItem(text: String){
    Log.i("TextItem: ", text)

    Text(text = text,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp)
}
