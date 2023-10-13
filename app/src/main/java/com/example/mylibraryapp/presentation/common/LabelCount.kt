package com.example.mylibraryapp.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.mylibraryapp.R

@Composable
fun LabelCount(number: Int) {

    val text = stringResource(id = R.string.label_results)

    Text(
//        modifier = Modifier
//            .padding(
//                start = dimensionResource(id = R.dimen.result_start_padding)
//            ),
        text = "$number, $text",
        fontSize = 16.sp
    )
}