package com.example.contracts

import com.example.models.Term

interface ISaveTermUseCase {
    operator fun invoke(term: Term)
}