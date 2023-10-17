package com.example.mylibraryapp.domain.usecase.loan

import com.example.mylibraryapp.common.Resource
import com.example.mylibraryapp.data.remote.dto.toAuthor
import com.example.mylibraryapp.data.remote.dto.toBook
import com.example.mylibraryapp.data.remote.dto.toLoan
import com.example.mylibraryapp.domain.model.Author
import com.example.mylibraryapp.domain.model.Book
import com.example.mylibraryapp.domain.model.Loan
import com.example.mylibraryapp.domain.repository.MyLibraryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllLoansByClientIDUseCase @Inject constructor(
    private val repository: MyLibraryRepository
) {

    operator fun invoke(id: Int) : Flow<Resource<List<Loan>>> = flow {

        try {

            emit(Resource.Loading())
            val data = repository.getAllLoansByClientID(id)
            val list = data.map { loanDTO ->
                loanDTO.toLoan()
            }
            emit(Resource.Success(data = list))

        } catch (e: Exception) {

            emit(Resource.Error(e.localizedMessage ?: "error GetAllLoansByClientIDUseCase"))

        }
    }
}