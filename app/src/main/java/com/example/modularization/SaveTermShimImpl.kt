package com.example.modularization

import androidx.fragment.app.FragmentManager
import com.example.terms.list.ListTermsFragment
import com.example.terms.save.SaveTermShim

class SaveTermShimImpl(private val fragmentManager: FragmentManager): SaveTermShim {

    override fun onSaveTerm() {
        fragmentManager.beginTransaction().apply {
            replace(R.id.container, ListTermsFragment())
            commitNowAllowingStateLoss()
        }
    }
}