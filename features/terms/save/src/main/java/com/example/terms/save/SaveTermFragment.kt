package com.example.terms.save

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.di.Dependencies
import com.example.models.Term
import com.example.provider.Provider
import com.example.terms.save.databinding.SaveFragmentBinding
import com.example.usecase.SaveTermUseCase
import kotlinx.coroutines.launch

class SaveTermFragment : Fragment(R.layout.save_fragment) {

    private val dependencies: Dependencies?
        get() = (activity as? Provider<Dependencies>)?.value

    private val saveTermUseCase: SaveTermUseCase?
        get() = dependencies?.saveTermUseCase as? SaveTermUseCase

    private val shim: SaveTermShim?
        get() = dependencies?.saveTermShim as? SaveTermShim

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SaveFragmentBinding.bind(view).apply {
            button.setOnClickListener {
                lifecycleScope.launch {
                    saveTermUseCase?.invoke(Term(editText.text.toString()))
                    shim?.onSaveTerm()
                }
            }
        }
    }
}
