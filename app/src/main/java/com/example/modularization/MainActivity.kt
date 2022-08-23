package com.example.modularization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.example.cache.SessionCache
import com.example.di.Dependencies
import com.example.provider.Provider
import com.example.repository.TermsRepositoryImpl
import com.example.terms.SaveTermFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOf

class MainActivity : AppCompatActivity(), Provider<Dependencies> {

    override val value: Dependencies by lazy {
        Dependencies(
            TermsRepositoryImpl(
                SessionCache(MutableSharedFlow(replay = 1, extraBufferCapacity = 1))
            ),
            SaveTermShimImpl(
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
