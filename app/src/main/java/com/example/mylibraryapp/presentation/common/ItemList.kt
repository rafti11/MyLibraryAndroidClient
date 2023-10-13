package com.example.mylibraryapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Author

// Todo: Check later weight modifier.
@Composable
fun ItemList(modifier: Modifier, author: Author, onClick: () -> Unit) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = author.name.substring(0,1).uppercase(), fontSize = 40.sp, fontWeight = FontWeight.Black,
            modifier = Modifier
                .weight(0.2f)
                .drawBehind {
                    drawCircle(color = Color.Red)
                },
            textAlign = TextAlign.Center
//                .padding(18.dp)
//                .drawBehind {
//                    drawCircle(
//                        color = Color.Red,
//                        radius = this.size.minDimension
//                    )
//                }
        )

        Text(
            text = author.name,
            fontSize = 22.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.item_start_padding))
        )

        IconButton(
            onClick = { onClick() }
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.arrow_forward),
                modifier = Modifier.weight(0.2f),
                contentDescription = null
            )
        }


    }
}

@Preview
@Composable
fun Tee() {

    ItemList(modifier = Modifier, author = Author(null, "john cena"), onClick = { println("click") })
}