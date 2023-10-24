package com.example.mylibraryapp.presentation.loan.listscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mylibraryapp.R
import com.example.mylibraryapp.domain.model.Loan
import com.example.mylibraryapp.presentation.common.LabelCount
import com.example.mylibraryapp.presentation.common.SearchBarCustom
import com.example.mylibraryapp.presentation.common.TitleLabel
import com.example.mylibraryapp.presentation.loan.LoanItem

@Composable
fun LoanScreen() {
    val viewModel: LoanListViewModel = hiltViewModel()
    val loans = viewModel.state.value.list
    val isLoading = viewModel.state.value.isLoading

    LoanScreenContent(loans = loans, isLoading = isLoading, modifier = Modifier.fillMaxSize())

}


@Composable
fun LoanScreenContent(loans: List<Loan>, isLoading: Boolean, modifier: Modifier) {


    Box(modifier = modifier) {

        if (isLoading){
            CircularProgressIndicator()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.default_screen_padding))
            ) {

                SearchBarCustom(hint = stringResource(id = R.string.search_loan), list = loans)

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.default_header)))

                TitleLabel(title = stringResource(id = R.string.label_loan_list))
                LabelCount(number = loans.size)

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.header_half)))


                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(loans.size) {
//                    val author = authorList[it]
                        LoanItem(loan = loans[it], onClick = {})
                    }
                }

            }
        }
        
    }
}
