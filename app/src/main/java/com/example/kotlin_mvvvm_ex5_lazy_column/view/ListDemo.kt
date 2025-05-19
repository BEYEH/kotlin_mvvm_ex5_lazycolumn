package com.example.kotlin_mvvvm_ex5_lazy_column.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_mvvvm_ex5_lazy_column.Model.MarvelChar
import com.example.kotlin_mvvvm_ex5_lazy_column.Model.getAllMarvelChars
import java.nio.file.WatchEvent

@Composable
fun ListDemo() {
    LazyColumnDemo()
}

/**
 * Render the data which can show in the view.
 */
@Composable
fun LazyColumnDemo() {
    var myList = listOf<String>(
        "a", "b", "c", "d", "e", "f",
        "g", "h", "i", "k", "l", "m",
        "n", "o", "p", "q", "r", "s"
    )

    var marvelList = getAllMarvelChars()

//    LazyColumn(content = {
//        itemsIndexed(myList, itemContent = { index, item ->
//            TextItem(text = "Item $item")
//        })
//    })

    LazyColumn(content = {
        itemsIndexed(marvelList, itemContent = { index, item ->
            MarvelItem(item = item)
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
fun TextItem(text: String) {
    Log.i("TextItem: ", text)

    Text(
        text = text,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}

@Composable
fun MarvelItem(item: MarvelChar) {
    var context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Toast.makeText(context, "Clicked ${item.charName}", Toast.LENGTH_SHORT).show()
            }
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.name,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
                .scale(1.0f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = item.charName,
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = item.name,
                style = TextStyle(fontSize = 22.sp)
            )
        }
    }
}
