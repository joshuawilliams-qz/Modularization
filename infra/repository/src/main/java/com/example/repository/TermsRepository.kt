package com.example.repository

import com.example.models.Term
import kotlinx.coroutines.flow.Flow

interface TermsRepository {

    val terms: Flow<List<Term>>

    suspend fun save(term: Term)
}
