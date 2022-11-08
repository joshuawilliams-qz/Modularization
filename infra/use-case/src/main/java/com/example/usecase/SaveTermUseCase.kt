package com.example.usecase

import com.example.contracts.usecase.ISaveTermUseCase
import com.example.models.Term
import com.example.contracts.repository.TermsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SaveTermUseCase(
    private val termsRepository: TermsRepository,
    private val scope: CoroutineScope
) : ISaveTermUseCase {

    override operator fun invoke(term: Term) {
        if (term.value.isNotBlank()) {
            scope.launch { termsRepository.save(term) }
        }
    }
}