package com.example.terms.list

import com.example.models.Term
import kotlinx.coroutines.flow.Flow

interface ListTermsUseCase {

    operator fun invoke(): Flow<List<Term>>
}