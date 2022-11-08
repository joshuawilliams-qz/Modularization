package com.example.contracts.usecase

import com.example.models.Term

interface ISaveTermUseCase {
    operator fun invoke(term: Term)
}