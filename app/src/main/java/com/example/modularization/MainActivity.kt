package com.example.modularization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.example.cache.SessionCache
import com.example.di.Dependencies
import com.example.provider.Provider
import com.example.repository.CachedTermsRepository
import com.example.repository.UserRepository
import com.example.terms.list.ListTermsUseCaseImpl
import com.example.terms.save.SaveTermFragment
import com.example.usecase.GetTermsUseCase
import com.example.usecase.GetUserUseCase
import com.example.usecase.SaveTermUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow

class MainActivity : AppCompatActivity(), Provider<Dependencies> {

    private val repository = CachedTermsRepository(
        SessionCache(MutableSharedFlow(replay = 1, extraBufferCapacity = 1))
    )

    private lateinit var userRepository: UserRepository

    private val getUserCase = GetUserUseCase(userRepository)

    private val getTermsUseCase = GetTermsUseCase(repository)

    override val value: Dependencies by lazy {
        Dependencies(
            listTermsUseCase = ListTermsUseCaseImpl(getUserCase, getTermsUseCase),
            saveTermUseCase = SaveTermUseCase(repository, GlobalScope),
            saveTermShim = SaveTermShimImpl(
                supportFragmentManager
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findViewById<FragmentContainerView>(R.id.container).apply {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(id, SaveTermFragment())
            fragmentTransaction.commitNowAllowingStateLoss()
        }
    }
}
