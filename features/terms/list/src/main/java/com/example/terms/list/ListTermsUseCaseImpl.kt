package com.example.terms.list

import com.example.contracts.usecase.IGetTermsUseCase
import com.example.contracts.usecase.IGetUserUseCase
import com.example.models.Term
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class ListTermsUseCaseImpl(
    private val getUserCase: IGetUserUseCase,
    private val getTermsUseCase: IGetTermsUseCase
) : ListTermsUseCase {

    override operator fun invoke(): Flow<List<Term>> =
        combine(getUserCase(), getTermsUseCase()) { user, terms ->
            terms.filter { it.id.contains(user.id) }
        }
}
