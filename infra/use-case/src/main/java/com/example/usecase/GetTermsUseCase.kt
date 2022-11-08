package com.example.usecase

import com.example.contracts.usecase.IGetTermsUseCase
import com.example.models.Term
import com.example.contracts.repository.TermsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTermsUseCase(
    private val termsRepository: TermsRepository
) : IGetTermsUseCase {

    override operator fun invoke(): Flow<List<Term>> {
        return termsRepository.terms.map { list -> list.filter { it.value.isNotBlank() } }
    }
}
