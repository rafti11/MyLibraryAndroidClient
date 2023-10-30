package com.example.mylibraryapp.presentation.loan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.model.Loan


@Composable
fun LoanItem(loan: Loan, onClick: () -> Unit) {

    val dateOut = stringResource(id = R.string.label_loan_date_out)
    val dateReturned = stringResource(id = R.string.label_loan_date_returned)

    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(id = R.dimen.item_start_padding))
            ) {
                Text(
                    text = loan.bookTitle,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.fillMaxWidth()

                )
                Divider(color = Color.Black)
                Text(
                    text = dateOut + " ${loan.dateOut}",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = dateReturned + " ${loan.dateReturned}",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column {
                IconButton(
                    onClick = { onClick() }
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.arrow_forward
                        ),
                        contentDescription = null
                    )
                }
            }


        }
    }

}

//@Preview
//@Composable
//fun Tee() {
//
//    ItemList(
//        loan = Loan(
//            dateDue = "2023-10-34",
//            dateReturned = "2023-10-18 11:26:52",
//            bookId = 1,
//            bookTitle = "My car and my bike",
//            dateOut = "2023-10-17 11:26:52"
//        ),
//        onClick = { println("click") })
//}
