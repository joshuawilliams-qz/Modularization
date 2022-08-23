package com.example.terms.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.di.Dependencies
import com.example.models.Term
import com.example.provider.Provider
import com.example.repository.TermsRepository
import com.example.terms.R
import com.example.terms.SaveTermShim
import com.example.terms.databinding.SaveFragmentBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ListTermsFragment : Fragment(R.layout.list_fragment) {

    private val dependencies: Dependencies?
        get() = (activity as? Provider<Dependencies>)?.value

    private val repository: TermsRepository?
        get() = dependencies?.termsRepository as? TermsRepository

    private val shim: SaveTermShim?
        get() = dependencies?.saveTermShim as? SaveTermShim

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SaveFragmentBinding.bind(view).apply {
            button.setOnClickListener {
                lifecycleScope.launch {
                    repository?.save(Term(editText.text.toString()))
                    shim?.onSaveTerm()
                }
            }
        }
    }
}
