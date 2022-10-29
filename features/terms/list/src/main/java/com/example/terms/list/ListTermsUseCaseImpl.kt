package com.example.terms.list

import com.example.contracts.IGetTermsUseCase
import com.example.contracts.IGetUserUseCase
import com.example.models.Term
import com.example.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull

class ListTermsUseCaseImpl(
    private val getUserCase: IGetUserUseCase,
    private val getTermsUseCase: IGetTermsUseCase
) : ListTermsUseCase {

    override operator fun invoke(): Flow<List<Term>> =
        combine(getUserCase(), getTermsUseCase()) { user, terms ->
            terms.filter { it.id.contains(user.id) }
        }
}
