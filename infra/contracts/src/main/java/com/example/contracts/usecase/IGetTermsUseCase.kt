package com.example.contracts.usecase

import com.example.models.Term
import kotlinx.coroutines.flow.Flow

interface IGetTermsUseCase {
    operator fun invoke(): Flow<List<Term>>
}