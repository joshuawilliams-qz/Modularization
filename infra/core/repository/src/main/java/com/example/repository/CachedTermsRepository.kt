package com.example.repository

import com.example.cache.Cache
import com.example.models.Term
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class CachedTermsRepository(
    private val cache: Cache<List<Term>>
): TermsRepository {

    override val terms: Flow<List<Term>> = cache.value.map { it ?: emptyList() }

    override suspend fun save(term: Term) {
        val list = cache.value.firstOrNull().orEmpty().toMutableList()
        list.add(term)
        cache.set(list)
    }
}
