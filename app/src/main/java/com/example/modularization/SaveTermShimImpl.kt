package com.example.modularization

import androidx.fragment.app.FragmentManager
import com.example.terms.SaveTermShim

class SaveTermShimImpl(private val fragmentManager: FragmentManager): SaveTermShim {

    override fun onSaveTerm() {
        fragmentManager.beginTransaction().apply {
            replace(R.id.container, TermsListFragment())
            commitNowAllowingStateLoss()
        }
    }
}