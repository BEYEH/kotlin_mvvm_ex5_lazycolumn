package com.example.kotlin_mvvvm_ex5_lazy_column.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListDemo() {
    SimpleColumn()
}

@Composable
fun SimpleColumn() {
    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        for (i in 1..100) {
            Text(text = "Item $i",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }
    }
}