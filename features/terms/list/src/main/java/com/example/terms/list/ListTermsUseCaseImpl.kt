package com.example.terms.list

import com.example.models.Term
import com.example.models.User
import com.example.usecase.GetTermsUseCase
import com.example.usecase.GetUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull

class ListTermsUseCaseImpl(
    private val getUserCase: GetUserUseCase,
    private val getTermsUseCase: GetTermsUseCase
) : ListTermsUseCase {

    override operator fun invoke(): Flow<List<Term>> =
        combine(getUserCase(), getTermsUseCase()) { user, terms ->
            terms.filter { it.id.contains(user.id) }
        }
}
